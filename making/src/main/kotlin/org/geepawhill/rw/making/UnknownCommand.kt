package org.geepawhill.rw.making

class UnknownCommand(val request: Request) : Command {
    override fun execute(): String {
        return Response.unknownCommandError(request.command).toJson()
    }
}
