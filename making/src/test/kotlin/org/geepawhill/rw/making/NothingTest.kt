package org.geepawhill.rw.making

import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.net.ServerSocket
import java.net.Socket
import java.net.SocketTimeoutException
import java.util.concurrent.atomic.AtomicBoolean

class Client() {
    val socket = Socket("localhost", 3000)
    val input = BufferedReader(InputStreamReader(socket.getInputStream()))
    val output = PrintStream(socket.getOutputStream(), true)

    fun send(message: String): String {
        println("Client --> $message")
        output.println(message)
        val result = input.readLine()
        println("Client <-- $result")
        return result
    }
}

class ContinueFlag {
    private val keepGoing = AtomicBoolean(true)
    val isTrue: Boolean get() = keepGoing.get()

    @Synchronized
    fun finished() {
        keepGoing.set(false)
    }
}

class Server(val continueFlag: ContinueFlag) {
    fun run() {
        println("Starting server thread.")
        val socket = ServerSocket(3000)
        while (continueFlag.isTrue) {
            socket.soTimeout = 100
            try {
                val accepted = socket.accept()
                val client = Thread {
                    println("Accepted socket")
                    val input = BufferedReader(InputStreamReader(accepted.getInputStream()))
                    while (true) {
                        val message = input.readLine()
                        val output = PrintStream(accepted.getOutputStream(), true)
                        output.println("You said '$message'")
                    }
                }
                client.start()
            } catch (ignored: SocketTimeoutException) {
            }
        }
        println("Ending server thread.")
        socket.close()
    }
}

class ServerTester(val test: ServerTester.() -> Unit) {
    init {
        // Start a server
        val inTest = ContinueFlag()
        val server = Server(inTest)
        val serverThread = Thread {
            server.run()
        }
        serverThread.start()
        test()
        inTest.finished()
        serverThread.join()
    }
}


class NothingTest {

    @Test
    fun `single client, single message`() {
        ServerTester {
            val client1 = Client()
            client1.send("Hi Mom!")
        }
    }

    @Test
    fun `single client, two messages`() {
        ServerTester {
            val client1 = Client()
            client1.send("Hi Mom!")
            client1.send("Hey Dad!")
        }
    }
}