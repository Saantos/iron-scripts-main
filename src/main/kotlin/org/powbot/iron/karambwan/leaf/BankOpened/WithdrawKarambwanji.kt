package org.example.org.powbot.iron.karambwan.leaf.BankOpened

import org.example.org.powbot.iron.karambwan.Script
import org.powbot.api.rt4.Bank
import org.powbot.api.script.tree.Leaf

class WithdrawKarambwanji(script: Script) : Leaf<Script>(script, "Withdrawing fish barrel") {
    override fun execute() {
        Bank.withdraw(3150,Bank.Amount.ALL)
    }
}