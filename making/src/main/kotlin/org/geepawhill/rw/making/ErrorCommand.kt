package org.geepawhill.rw.making

class ErrorCommand(val message: String) : Command {
    override fun execute(): String {
        return Response.errorResponse(message).toJson()
    }
}