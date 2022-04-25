package org.geepawhill.rw.making

class EchoCommand(val text: String) : Command {

    override fun unsafeRun(): Response {
        return Response.echo(text)
    }

    companion object {
        fun unsafeFrom(request: Request): EchoCommand {
            return EchoCommand(request.arguments[0].content)
        }
    }
}