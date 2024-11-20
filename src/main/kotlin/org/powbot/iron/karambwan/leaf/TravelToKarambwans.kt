package org.example.org.powbot.iron.karambwan.leaf

import org.example.org.powbot.iron.karambwan.Script
import org.powbot.api.Condition.sleep
import org.powbot.api.Tile
import org.powbot.api.rt4.FairyRing
import org.powbot.api.rt4.GameObject
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Objects
import org.powbot.api.script.tree.Leaf

class TravelToKarambwans(script: Script) : Leaf<Script>(script, "Travelling to Karambwans") {
    override fun execute() {
        val fairyRingTile = Tile(2412, 4434, 0)
        Movement.moveTo(fairyRingTile)
        val fairyRing = Objects.stream().type(GameObject.Type.INTERACTIVE).name("Fairy ring").first()

        val lastDestination = fairyRing.actions().firstOrNull() { it.contains("DKP", true) }
        if (lastDestination != null) {
            fairyRing.interact(lastDestination)
            sleep(100)
            return
        }

        val configureAction = fairyRing.actions().firstOrNull { it.contains("configure", true) }
        if (!FairyRing.opened()) {
            fairyRing.interact(configureAction)
        }

        if (FairyRing.opened()) {
            FairyRing.teleport("DKP")
            return
        }

        return
    }
}