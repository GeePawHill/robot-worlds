package org.geepawhill.rw.making

class UnparseableCommand : Command {
    override fun execute(): String {
        return Response.unparseableCommand().toJson()
    }
}
