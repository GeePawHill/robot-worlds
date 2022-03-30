package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

val DISCONNECTED_RESPONSE = "ERROR: Not Connected."

class DirectConnectorTest {
    val connector = DirectConnector()

    @Test
    fun `send before connect gets error response`() {
        assertThat(connector.send("Hi Mom!")).isEqualTo(DISCONNECTED_RESPONSE)
    }

    @Test
    fun `connect returns true on success`() {
        assertThat(connector.connect()).isTrue()
    }

    class DirectConnector {
        fun connect(): Boolean {
            return true
        }

        fun send(message: String): String {
            return DISCONNECTED_RESPONSE
        }

    }
}