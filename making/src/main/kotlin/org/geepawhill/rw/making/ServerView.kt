package org.geepawhill.rw.making

import tornadofx.*

class ServerView : Fragment() {
    override val root = borderpane {
        minWidth = 400.0
        top = stackpane {
            label("Server View")
        }
    }
}