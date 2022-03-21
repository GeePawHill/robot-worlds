package org.geepawhill.rw.making

import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

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
        val server = Thread {
            println("Starting server thread.")
            val socket = ServerSocket(3000)
            val accepted = socket.accept()
            println("Accepted socket")
            val input = BufferedReader(InputStreamReader(accepted.getInputStream()))
            val message = input.readLine()
            println("Received: $message")
            val output = PrintWriter(accepted.getOutputStream())
            output.println("You said '$message'")
            println("Ending server thread.")
            socket.close()
        }
        server.start()

        // Connect to the server
        println("Connecting to server.")
        val client = Socket("localhost", 3000)
        println("Connected to server.")
        val output = PrintStream(client.getOutputStream())
        output.println("Hi mom!")
        val input = BufferedReader(InputStreamReader(client.getInputStream()))
        val message = input.readLine()
        println("Client heard: '$message'")
        server.join()
    }
}