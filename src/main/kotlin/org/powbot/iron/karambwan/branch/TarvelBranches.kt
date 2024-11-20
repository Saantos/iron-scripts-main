package org.example.org.powbot.iron.karambwan.branch

import org.example.org.powbot.iron.karambwan.Constants
import org.example.org.powbot.iron.karambwan.Script
import org.example.org.powbot.iron.karambwan.leaf.Fish
import org.example.org.powbot.iron.karambwan.leaf.TravelToKarambwans
import org.powbot.api.rt4.Npcs
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class ShouldTravelToKarambwans(script: Script) : Branch<Script>(script, "Should Travel") {
    override val successComponent: TreeComponent<Script> = Fishing(script)
    override val failedComponent: TreeComponent<Script> = TravelToKarambwans(script)

    override fun validate(): Boolean {
        return Npcs.stream().id(Constants.FISHING_SPOT_ID).first().valid()
    }
}