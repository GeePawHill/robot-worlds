package org.geepawhill.rw.making

class Commander : Receiver {
    override fun receive(message: String): String {
        try {
            val request = Request.unsafeFromJson(message)
            val command = EchoCommand(request)
            return command.execute()
        } catch (unused: Throwable) {
            return Response.badRequestError().toJson()
        }
    }

}