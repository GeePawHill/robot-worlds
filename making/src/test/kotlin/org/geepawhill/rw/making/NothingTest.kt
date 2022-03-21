package org.geepawhill.rw.making

import org.junit.jupiter.api.Test
import java.net.ServerSocket
import java.net.Socket

class NothingTest {

    @Test
    fun `Idunno2`() {
        // Start a server
        val server = Thread {
            println("Starting server thread.")
            val socket = ServerSocket(3000)
            socket.accept()
            println("Ending server thread.")
        }
        server.start()

        // Connect to the server
        println("Connecting to server.")
        Socket("localhost", 3000)
        println("Connected to server.")
        server.join()
    }
}