package org.geepawhill.rw.making

import tornadofx.App
import tornadofx.launch

class MakerMain : App(MakerView::class)

fun main(args:Array<String>) {
    launch<MakerMain>(args)
}