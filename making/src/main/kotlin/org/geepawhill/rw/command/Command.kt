package org.geepawhill.rw.command

import org.geepawhill.rw.transport.Request
import org.geepawhill.rw.transport.Response

interface Command {
    fun unsafeRun(): Response

    companion object {

        fun fromRequest(request: Request): Command {
            try {
                return unsafeFromRequest(request)
            } catch (unused: Throwable) {
                return UnparseableCommand()
            }
        }

        private fun unsafeFromRequest(request: Request) = when (request.command) {
            "unparseable" -> UnparseableRequestCommand()
            "echo" -> EchoCommand.unsafeFrom(request)
            else -> UnknownCommand(request)
        }
    }
}