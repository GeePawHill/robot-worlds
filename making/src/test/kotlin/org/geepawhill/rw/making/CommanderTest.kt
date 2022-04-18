package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class CommanderTest {

    val commander = Commander()

    @Test
    fun `handles echo request`() {
        val response = commander.receive(Request.echoRequest("Hi Mom!").toJson())
        assertThat(response).isEqualTo(Response.echoResponse("Hi Mom!").toJson())
    }

    @Test
    fun `handles non-request with badRequestError`() {
        val response = commander.receive("This is not a request.")
        assertThat(response).isEqualTo(Response.badRequestError().toJson())
    }

    @Test
    fun `handles unknown command with unknownCommandError`() {
        val response = commander.receive(Request("non-command", "n/a", emptyList()).toJson())
        assertThat(response).isEqualTo(Response.unknownCommandError("non-command").toJson())
    }
}