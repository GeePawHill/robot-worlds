package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.containsExactly
import assertk.assertions.isEqualTo
import org.geepawhill.rw.transport.Request
import org.geepawhill.rw.transport.Response
import org.junit.jupiter.api.Test

class ServerModelTest {

    val commander = Commander()
    val model = ServerModel(commander)

    @Test
    fun `notify adds to events`() {
        val event = Request.echoRequest("Hi Mom!")
        model.notify(event)
        assertThat(model.activity).containsExactly(event)
    }

    @Test
    fun `receive passes on to Commander`() {
        val event = Request.echoRequest("Hi Mom!")
        val response = model.receive(event.toJson())
        assertThat(response).isEqualTo(Response.echo("Hi Mom!").toJson())
    }
}