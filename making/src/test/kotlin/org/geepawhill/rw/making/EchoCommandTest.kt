package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EchoCommandTest {

    @Test
    fun `command returns echoResponse text`() {
        val command = EchoCommand("Hi Mom!")
        assertThat(command.execute()).isEqualTo(Response.echoResponse("Hi Mom!").toJson())
    }

    @Test
    fun `constructs from well-formed echo request, too`() {
        val command = EchoCommand(Request.echoRequest("Hi Mom!"))
        assertThat(command.execute()).isEqualTo(Response.echoResponse("Hi Mom!").toJson())
    }

    @Test
    fun `throws on missing or bad argument`() {
        assertThrows<IndexOutOfBoundsException> {
            EchoCommand(Request("echo", "n/a", emptyList()))
        }
    }
}