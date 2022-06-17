package org.geepawhill.rw.making

import org.geepawhill.rw.command.Event
import org.geepawhill.rw.transport.Receiver
import tornadofx.*

class ServerModel : Watcher, Receiver {

    val activity = observableListOf<Event>()
    val commander = Commander(this)

    override fun notify(event: Event) {
        runLater {
            activity += event
        }
    }

    override fun receive(message: String): String {
        return commander.receive(message)
    }
}