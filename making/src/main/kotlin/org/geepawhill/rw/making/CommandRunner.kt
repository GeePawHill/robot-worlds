package org.geepawhill.rw.making

class CommandRunner(val command: Command) {
    fun run(): String {
        try {
            return command.execute()
        } catch (printed: Throwable) {
            printed.printStackTrace()
            return Response.internalError().toJson()
        }
    }
}