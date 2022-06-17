package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.containsExactly
import assertk.assertions.isEqualTo
import org.geepawhill.rw.transport.Request
import org.geepawhill.rw.transport.Response
import org.junit.jupiter.api.Test

class ServerModelTest {

    val model = ServerModel()

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

    @Test
    fun `receive gets notifications`() {
        val event = Request.echoRequest("Hi Mom!")
        model.receive(event.toJson())
        assertThat(model.activity).containsExactly(Request.echoRequest("Hi Mom!"))
    }
}