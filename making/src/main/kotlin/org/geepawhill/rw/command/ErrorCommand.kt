package org.geepawhill.rw.command

import org.geepawhill.rw.transport.Response

class ErrorCommand(val message: String) : Command {
    override fun unsafeRun(): Response {
        return Response.error(message)
    }
}