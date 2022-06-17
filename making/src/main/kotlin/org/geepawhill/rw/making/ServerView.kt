package org.geepawhill.rw.making

import tornadofx.*

class ServerView(val model: ServerModel) : Fragment() {

    override val root = borderpane {
        minWidth = 400.0
        top = vbox {
            stackpane {
                label("Server View")
            }
        }
        center = listview(model.activity)
    }
}