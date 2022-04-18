package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class CommandRunnerTest {

    @Test
    fun `returns normal command's response`() {
        val result = CommandRunner(EchoCommand("Hi Mom!")).run()
        assertThat(result).isEqualTo(Response.echo("Hi Mom!").toJson())
    }

    @Test
    fun `returns internal error from throwing command`() {
        val throwingCommand = object : Command {
            override fun unsafeRun(): Response {
                throw Exception("Something exceptional happened.")
            }

        }
        val result = CommandRunner(throwingCommand).run()
        assertThat(result).isEqualTo(Response.internalError().toJson())
    }

}