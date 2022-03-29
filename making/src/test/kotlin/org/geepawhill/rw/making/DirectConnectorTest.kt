package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

val DISCONNECTED_RESPONSE = "ERROR: Not Connected."

class DirectConnectorTest {

    @Test
    fun `send before connect gets error response`() {
        assertThat(DirectConnector().send("Hi Mom!")).isEqualTo(DISCONNECTED_RESPONSE)
    }

    class DirectConnector {
        fun send(message: String): String {
            return DISCONNECTED_RESPONSE
        }

    }
}