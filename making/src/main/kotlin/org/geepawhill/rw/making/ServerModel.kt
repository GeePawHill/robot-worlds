package org.geepawhill.rw.making

import org.geepawhill.rw.command.Event
import org.geepawhill.rw.transport.Receiver
import tornadofx.*

class ServerModel(val commander: Commander) : Watcher, Receiver {
    val activity = observableListOf<Event>()

    override fun notify(event: Event) {
        activity += event
    }

    override fun receive(message: String): String {
        return commander.receive(message)
    }
}