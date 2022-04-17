package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ErrorCommandTest {
    @Test
    fun `command returns errorResponse text`() {
        val command = ErrorCommand("Hi Mom!")
        assertThat(command.execute()).isEqualTo(Response.errorResponse("Hi Mom!").toJson())
    }
}