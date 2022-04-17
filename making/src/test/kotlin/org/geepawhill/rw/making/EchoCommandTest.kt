package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class EchoCommand(val text: String) {
    fun execute(): String {
        return Response.echoResponse(text).toJson()
    }
}

class EchoCommandTest {

    @Test
    fun `command returns echoResponse text`() {
        val command = EchoCommand("Hi Mom!")
        assertThat(command.execute()).isEqualTo(Response.echoResponse("Hi Mom!").toJson())
    }
}