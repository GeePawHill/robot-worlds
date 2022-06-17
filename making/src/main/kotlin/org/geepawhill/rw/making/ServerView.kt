package org.geepawhill.rw.making

import org.geepawhill.rw.transport.Request
import tornadofx.*

class ServerView(val model: ServerModel) : Fragment() {

    override val root = borderpane {
        minWidth = 400.0
        top = vbox {
            stackpane {
                label("Server View")
            }
            toolbar {
                button("Echo Hey!") {
                    action {
                        model.receive(Request.echoRequest("Hey!").toJson())
                    }
                }
            }
        }
        center = listview(model.activity)
    }
}