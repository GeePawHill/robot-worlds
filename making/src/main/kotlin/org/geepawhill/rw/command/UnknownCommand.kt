package org.geepawhill.rw.command

import org.geepawhill.rw.transport.Request
import org.geepawhill.rw.transport.Response

class UnknownCommand(val request: Request) : Command {
    override fun unsafeRun(): Response {
        return Response.unknownCommandError(request.command)
    }
}
