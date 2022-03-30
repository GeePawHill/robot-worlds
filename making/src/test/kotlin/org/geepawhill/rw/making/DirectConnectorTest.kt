package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

val DISCONNECTED_RESPONSE = "ERROR: Not Connected."
val HARDWIRED_RESPONSE = "OKAY"

class DirectConnectorTest {
    val connector = DirectConnector(TestingReceiver())

    @Test
    fun `send before connect gets error response`() {
        assertThat(connector.send("Hi Mom!")).isEqualTo(DISCONNECTED_RESPONSE)
    }

    @Test
    fun `send after disconnect gets error response`() {
        connector.connect()
        connector.disconnect()
        assertThat(connector.send("Hi Mom!")).isEqualTo(DISCONNECTED_RESPONSE)
    }

    @Test
    fun `connect returns true on success`() {
        assertThat(connector.connect()).isTrue()
    }

    @Test
    fun `send after connect gets hardwired response`() {
        connector.connect()
        assertThat(connector.send("Him Mom!")).isEqualTo(HARDWIRED_RESPONSE)
    }

    interface Receiver {
        fun receive(message: String): String
    }

    class TestingReceiver() : Receiver {
        override fun receive(message: String): String {
            return HARDWIRED_RESPONSE
        }
    }

    class DirectConnector(val receiver: Receiver) {

        private var isConnected = false

        fun connect(): Boolean {
            isConnected = true
            return true
        }

        fun send(message: String): String {
            if (isConnected) return receiver.receive(message)
            return DISCONNECTED_RESPONSE
        }

        fun disconnect() {
            isConnected = false
        }

    }
}