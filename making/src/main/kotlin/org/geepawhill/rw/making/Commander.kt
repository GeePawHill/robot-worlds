package org.geepawhill.rw.making

class Commander : Receiver {
    override fun receive(message: String): String {
        try {
            val request = Request.unsafeFromJson(message)
            val command = parseCommand(request)
            return command.execute()
        } catch (unused: Throwable) {
            return Response.badRequestError().toJson()
        }
    }

    private fun parseCommand(request: Request): Command {
        when (request.command) {
            "echo" -> return EchoCommand(request)
            else -> return UnknownCommand(request)
        }
    }
}