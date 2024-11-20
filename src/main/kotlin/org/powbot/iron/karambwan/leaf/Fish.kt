package org.example.org.powbot.iron.karambwan.leaf

import org.example.org.powbot.iron.karambwan.Constants
import org.example.org.powbot.iron.karambwan.Script
import org.powbot.api.Condition.sleep
import org.powbot.api.rt4.Npcs
import org.powbot.api.script.tree.Leaf

class Fish(script: Script) : Leaf<Script>(script, "Fish") {
    override fun execute() {
        val spot = Npcs.stream().id(Constants.FISHING_SPOT_ID).first()
        spot.interact("Fish")
        sleep(1200)
    }
}