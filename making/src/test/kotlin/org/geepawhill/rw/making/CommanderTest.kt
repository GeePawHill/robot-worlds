package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.containsExactly
import assertk.assertions.isEqualTo
import org.geepawhill.rw.command.Event
import org.geepawhill.rw.transport.Request
import org.geepawhill.rw.transport.Response
import org.junit.jupiter.api.Test

class CommanderTest : Watcher {

    val events = mutableListOf<Event>()
    val commander = Commander(this)

    @Test
    fun `echo request gets echo response`() {
        val response = commander.receive(Request.echoRequest("Hi Mom!").toJson())
        assertThat(response).isEqualTo(Response.echo("Hi Mom!").toJson())
    }

    @Test
    fun `echo request notifies watcher`() {
        val request = Request.echoRequest("Hi Mom!")
        val response = commander.receive(request.toJson())
        assertThat(events).containsExactly(request)
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

    override fun notify(event: Event) {
        events += event
    }
}