package org.geepawhill.rw.making

class UnparseableRequestCommand : Command {
    override fun unsafeRun(): Response {
        return Response.unparseableRequest()
    }
}
