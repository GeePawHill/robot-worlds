package org.geepawhill.rw.making

class UnknownCommand(val request: Request) : Command {
    override fun unsafeRun(): Response {
        return Response.unknownCommandError(request.command)
    }
}
