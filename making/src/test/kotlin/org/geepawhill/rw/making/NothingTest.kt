package org.geepawhill.rw.making

import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.net.ServerSocket
import java.net.Socket

class NothingTest {

    @Test
    fun `Idunno2`() {
        // Start a server
        val server = Thread {
            println("Starting server thread.")
            val socket = ServerSocket(3000)
            val accepted = socket.accept()
            println("Accepted socket")
            val input = BufferedReader(InputStreamReader(accepted.getInputStream()))
            val message = input.readLine()
            println("Received: $message")
            println("Ending server thread.")
        }
        server.start()

        // Connect to the server
        println("Connecting to server.")
        val client = Socket("localhost", 3000)
        val output = PrintStream(client.getOutputStream())
        output.println("Hi mom!")
        println("Connected to server.")
        server.join()
    }
}