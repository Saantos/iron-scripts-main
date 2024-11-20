package org.example.org.powbot.iron.karambwan.branch

import org.example.org.powbot.iron.karambwan.Script
import org.example.org.powbot.iron.karambwan.leaf.Fish
import org.powbot.api.Condition.sleep
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.SimpleLeaf
import org.powbot.api.script.tree.TreeComponent

class Fishing(script: Script) : Branch<Script>(script, "ShouldBank?") {
    override val failedComponent: TreeComponent<Script> = Fish(script)
    override val successComponent: TreeComponent<Script> = SimpleLeaf(script, "Fishing") {
        if (Inventory.isFull()) {
            ShouldBank(script)
        }
    }

    override fun validate(): Boolean {
        return Players.local().animation() == 1193
    }
}