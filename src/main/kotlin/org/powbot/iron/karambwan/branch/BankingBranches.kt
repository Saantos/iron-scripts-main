package org.example.org.powbot.iron.karambwan.branch

import org.example.org.powbot.iron.Helpers.House
import org.example.org.powbot.iron.karambwan.Script
import org.example.org.powbot.iron.karambwan.leaf.UseFairyRing
import org.powbot.api.rt4.Bank
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class IsBankOpened(script: Script) : Branch<Script>(script, "Bank open") {
    override val successComponent: TreeComponent<Script> = ShouldWithdrawBarrel(script)
    override val failedComponent: TreeComponent<Script> = ShouldWithdrawBarrel(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}

class ShouldBank(script: Script) : Branch<Script>(script, "") {
    override val successComponent: TreeComponent<Script> = UseFairyRing(script)
    override val failedComponent: TreeComponent<Script> = UseFairyRing(script)

    override fun validate(): Boolean {
        return false
    }
}

class InHouse(script: Script) : Branch<Script>(script, "In house") {
    override val successComponent: TreeComponent<Script> = UseFairyRing(script)
    override val failedComponent: TreeComponent<Script> = UseFairyRing(script)

    override fun validate(): Boolean {
        return House.inside()
    }
}
