package org.geepawhill.rw.command

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.geepawhill.rw.transport.Response
import org.junit.jupiter.api.Test

class ErrorCommandTest {
    @Test
    fun `command returns errorResponse text`() {
        val command = ErrorCommand("Hi Mom!")
        assertThat(command.unsafeRun()).isEqualTo(Response.error("Hi Mom!"))
    }
}