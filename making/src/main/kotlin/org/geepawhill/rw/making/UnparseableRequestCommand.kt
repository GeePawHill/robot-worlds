package org.geepawhill.rw.making

class UnparseableRequestCommand : Command {
    override fun execute(): String {
        return Response.unparseableRequest().toJson()
    }
}
