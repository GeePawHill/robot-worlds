package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class CommanderTest {

    val commander = Commander()

    @Test
    fun `echo request gets echo response`() {
        val response = commander.receive(Request.echoRequest("Hi Mom!").toJson())
        assertThat(response).isEqualTo(Response.echo("Hi Mom!").toJson())
    }

    @Test
    fun `non-request gets UnparseableRequest`() {
        val response = commander.receive("This is not a request.")
        assertThat(response).isEqualTo(Response.unparseableRequest().toJson())
    }

    @Test
    fun `unknown command gets unknownCommand`() {
        val response = commander.receive(Request("non-command", "n/a", emptyList()).toJson())
        assertThat(response).isEqualTo(Response.unknownCommandError("non-command").toJson())
    }

    @Test
    fun `unparseable command bad or missing arguments gets UnparseableCommand`() {
        val response = commander.receive(Request("echo", "n/a", emptyList()).toJson())
        assertThat(response).isEqualTo(Response.unparseableCommand().toJson())
    }
}