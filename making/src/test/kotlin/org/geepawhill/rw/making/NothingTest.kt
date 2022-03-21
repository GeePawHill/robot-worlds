package org.geepawhill.rw.making

import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.net.ServerSocket
import java.net.Socket

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

class Server() {
    fun run() {
        println("Starting server thread.")
        val socket = ServerSocket(3000)
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
        println("Ending server thread.")
        socket.close()
    }
}

class NothingTest {

    @Test
    fun `Round 1`() {
        connectOnce()
    }

    @Test
    fun `Round 2`() {
        connectOnce()
    }

    private fun connectOnce() {
        // Start a server
        val server = Server()
        val serverThread = Thread {
            server.run()
        }
        serverThread.start()

        val client1 = Client()
        client1.send("Hi Mom!")
        client1.send("Hey Dad!")
        serverThread.join()
    }
}