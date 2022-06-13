package org.geepawhill.rw.command

import org.geepawhill.rw.transport.Response

class UnparseableCommand : Command {
    override fun unsafeRun(): Response {
        return Response.unparseableCommand()
    }
}
