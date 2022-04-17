package org.geepawhill.rw.making

class EchoCommand(val text: String) {

    constructor(request: Request) : this(request.arguments[0].content)

    fun execute(): String {
        return Response.echoResponse(text).toJson()
    }
}