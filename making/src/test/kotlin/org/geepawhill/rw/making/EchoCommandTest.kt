package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EchoCommandTest {

    @Test
    fun `command returns echoResponse text`() {
        val command = EchoCommand("Hi Mom!")
        assertThat(command.unsafeRun()).isEqualTo(Response.echo("Hi Mom!"))
    }

    @Test
    fun `constructs from well-formed echo request, too`() {
        val command = EchoCommand.unsafeFrom(Request.echoRequest("Hi Mom!"))
        assertThat(command.unsafeRun()).isEqualTo(Response.echo("Hi Mom!"))
    }

    @Test
    fun `throws on missing or bad argument`() {
        assertThrows<IndexOutOfBoundsException> {
            EchoCommand.unsafeFrom(Request("echo", "n/a", emptyList()))
        }
    }
}