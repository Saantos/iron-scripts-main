package org.example.org.powbot.iron.karambwan.leaf.BankOpened

import org.example.org.powbot.iron.karambwan.Script
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf


class DepositKarambwans(script: Script) : Leaf<Script>(script, "Depositing Karambwans") {
    override fun execute() {
        val barrel = Inventory.stream().id(25584).first()
        if (barrel.valid()) {
            barrel.interact("Empty")
        }

        Bank.deposit(3142, Bank.Amount.ALL)
    }
}