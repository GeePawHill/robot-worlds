package org.geepawhill.rw.making

import org.geepawhill.rw.command.Event
import tornadofx.*

class ServerModel(val commander: Commander) : Watcher {
    val activity = observableListOf<Event>()
    
    override fun notify(event: Event) {
        activity += event
    }
}