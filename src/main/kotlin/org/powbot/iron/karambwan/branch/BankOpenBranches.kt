package org.example.org.powbot.iron.karambwan.branch

import org.example.org.powbot.iron.karambwan.Script
import org.example.org.powbot.iron.karambwan.leaf.BankOpened.*
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class ShouldWithdrawBarrel(script: Script) : Branch<Script>(script, "Withdraw barrel") {
    override val successComponent: TreeComponent<Script> = WithdrawBarrel(script)
    override val failedComponent: TreeComponent<Script> = ShouldWithdrawVessel(script)

    override fun validate(): Boolean {
        if (script.useFishBarrel) {
            return !Inventory.stream().name("Open fish barrel").first().valid()
        }
        return false
    }
}

class ShouldWithdrawVessel(script: Script) : Branch<Script>(script, "Withdraw vessel") {
    override val successComponent: TreeComponent<Script> = WithdrawVessel(script)
    override val failedComponent: TreeComponent<Script> = ShouldWithdrawKarambwanji(script)

    override fun validate(): Boolean {
        return !Inventory.stream().name("Karambwan vessel").first().valid()
    }
}

class ShouldWithdrawKarambwanji(script: Script) : Branch<Script>(script, "Withdraw Karambwanji") {
    override val successComponent: TreeComponent<Script> = WithdrawKarambwanji(script)
    override val failedComponent: TreeComponent<Script> = ShouldDepositFish(script)

    override fun validate(): Boolean {
        return !Inventory.stream().name("Raw karambwanji").first().valid()
    }
}

class ShouldDepositFish(script: Script) : Branch<Script>(script, "Deposit Karambwans") {
    override val successComponent: TreeComponent<Script> = DepositKarambwans(script)
    override val failedComponent: TreeComponent<Script> = ShouldTravelToKarambwans(script)

    override fun validate(): Boolean {
        return Inventory.stream().id(3142).first().valid()
    }
}
