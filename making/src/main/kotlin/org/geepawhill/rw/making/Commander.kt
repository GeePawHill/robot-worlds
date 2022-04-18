package org.geepawhill.rw.making

class Commander : Receiver {

    override fun receive(message: String): String {
        val request = Request.fromJson(message)
        val command = Command.fromRequest(request)
        return command.execute()
    }
}