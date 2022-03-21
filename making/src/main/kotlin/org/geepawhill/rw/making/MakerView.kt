package org.geepawhill.rw.making

import javafx.scene.text.Font
import tornadofx.View
import tornadofx.hbox
import tornadofx.label

class MakerView : View("Robot World (Making)") {
    override val root = hbox {
        minWidth = 400.0
        label("Hi Mom!") {
            font = Font.font(25.0)
        }
    }
}