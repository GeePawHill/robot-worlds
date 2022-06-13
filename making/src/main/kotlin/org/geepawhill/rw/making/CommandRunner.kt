package org.geepawhill.rw.making

import org.geepawhill.rw.command.Command
import org.geepawhill.rw.transport.Response

class CommandRunner(val command: Command) {
    fun run(): String {
        try {
            return command.unsafeRun().toJson()
        } catch (printed: Throwable) {
            printed.printStackTrace()
            return Response.internalError().toJson()
        }
    }
}