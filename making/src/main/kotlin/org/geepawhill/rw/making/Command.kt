package org.geepawhill.rw.making

interface Command {
    fun execute(): String

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
            "echo" -> EchoCommand(request)
            else -> UnknownCommand(request)
        }
    }
}