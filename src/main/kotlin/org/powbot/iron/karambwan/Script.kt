package org.example.org.powbot.iron.karambwan

import org.example.org.powbot.iron.karambwan.branch.IsBankOpened
import org.powbot.api.script.OptionType
import org.powbot.api.script.ScriptConfiguration
import org.powbot.api.script.ScriptManifest
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import java.util.logging.Logger


@ScriptManifest(
    name = "Iron Karambwans",
    author = "ironmeme",
    version = "0.1",
    scriptId = "",
    description = "fishes karambwans"
)

@ScriptConfiguration.List(
    [
        ScriptConfiguration(
            name = "Fish Barrel",
            description = "Use fish barrel?",
            optionType = OptionType.BOOLEAN,
            defaultValue = "true"
        ),
        ScriptConfiguration(
            name = "Banking Method",
            description = "Method of banking?",
            optionType = OptionType.STRING,
            allowedValues = arrayOf("Seers", "Crafting Guild", "Zanaris"),
            defaultValue = "Zanaris"
        )
    ]
)

class Script: TreeScript() {
    private val logger = Logger.getLogger(this.javaClass.name)

    val useFishBarrel by lazy { getOption<Boolean>("Fish Barrel") }
    val bankingMethod by lazy { getOption<String>("Banking Method") }

    override val rootComponent: TreeComponent<*> by lazy {
        IsBankOpened(this)
    }

    override fun onStart() {
        super.onStart()
    }
}

fun main() {
    Script().startScript()
}