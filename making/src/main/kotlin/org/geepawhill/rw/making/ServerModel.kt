package org.geepawhill.rw.making

import org.geepawhill.rw.command.Event
import tornadofx.*

class ServerModel(val commander: Commander) {
    val activity = observableListOf<Event>()
}