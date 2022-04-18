package org.geepawhill.rw.making

class UnparseableCommand : Command {
    override fun unsafeRun(): Response {
        return Response.unparseableCommand()
    }
}
