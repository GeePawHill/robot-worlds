package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import org.geepawhill.rw.making.DirectConnector.Companion.DISCONNECTED_RESPONSE
import org.junit.jupiter.api.Test


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

    class TestingReceiver() : Receiver {
        override fun receive(message: String): String {
            return HARDWIRED_RESPONSE
        }
    }
}

