package org.geepawhill.rw.making

class ErrorCommand(val message: String) : Command {
    override fun unsafeRun(): Response {
        return Response.error(message)
    }
}