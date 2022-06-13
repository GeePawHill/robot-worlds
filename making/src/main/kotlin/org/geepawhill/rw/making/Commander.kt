package org.geepawhill.rw.making

import org.geepawhill.rw.command.Command
import org.geepawhill.rw.transport.Receiver
import org.geepawhill.rw.transport.Request

class Commander : Receiver {

    override fun receive(message: String): String {
        val request = Request.fromJson(message)
        val command = Command.fromRequest(request)
        return CommandRunner(command).run()
    }
}