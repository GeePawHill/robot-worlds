package org.geepawhill.rw.making

import org.geepawhill.rw.transport.Request
import tornadofx.*

class ServerView(val commander: Commander) : Fragment() {

    val model = ServerModel(commander)

    override val root = borderpane {
        minWidth = 400.0
        top = vbox {
            stackpane {
                label("Server View")
            }
            toolbar {
                button("Fake Event") {
                    action {
                        model.activity.add(Request("FAKE", "fake", emptyList()))
                    }
                }
            }
        }
        center = listview(model.activity)
    }
}