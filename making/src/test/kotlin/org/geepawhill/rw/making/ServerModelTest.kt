package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.containsExactly
import org.geepawhill.rw.transport.Request
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
}