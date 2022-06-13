package org.geepawhill.rw.command

import org.geepawhill.rw.transport.Response

class UnparseableRequestCommand : Command {
    override fun unsafeRun(): Response {
        return Response.unparseableRequest()
    }
}
