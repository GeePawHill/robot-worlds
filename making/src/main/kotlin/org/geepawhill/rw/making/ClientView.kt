package org.geepawhill.rw.making

import tornadofx.*


class ClientView : Fragment() {

    override val root = borderpane {
        minWidth = 400.0
        top = stackpane {
            label("Client View")
        }
    }
}