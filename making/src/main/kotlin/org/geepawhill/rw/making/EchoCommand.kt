package org.geepawhill.rw.making

class EchoCommand(val text: String) : Command {

    constructor(request: Request) : this(request.arguments[0].content)

    override fun unsafeRun(): Response {
        return Response.echo(text)
    }
}