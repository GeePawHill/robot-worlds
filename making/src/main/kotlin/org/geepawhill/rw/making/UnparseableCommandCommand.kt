package org.geepawhill.rw.making

class UnparseableCommandCommand : Command {
    override fun execute(): String {
        return Response.unparseableCommandError().toJson()
    }
}
