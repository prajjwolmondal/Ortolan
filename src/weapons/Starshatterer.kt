package weapons

import utils.UserPromptGenerator

class Starshatterer: Weapon{

    override var damage = 50
    override val userPromptGenerator = UserPromptGenerator()
    override val itemValue = 100

    override fun describe() {
        userPromptGenerator.printText(arrayOf("The Star Shatterer is a very powerful experimental weapon. Tbh we're" +
                " not quite sure how it fires plasma at such high velocity, releasing a powerful blow to anything " +
                "unfortunate enough to come in its path. Due to its powerful nature, only a handful are made and they" +
                " sell out a nanosecond after they go up for sale.", "Stats:", "Manufactured by: Expom Command",
                "Damage: ${this.damage} units of armor", "Reload time: 30s",
                "Compatible with the following class of ships: Epoch & Halison"))
    }

    override fun getWeaponName(): String{ return "The Star Shatterer" }

}