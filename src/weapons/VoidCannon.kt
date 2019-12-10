package weapons

import utils.UserPromptGenerator

class VoidCannon: Weapon{

    override var damage = 50    // Bumping up to help with testing, default value should be 10
    override val userPromptGenerator = UserPromptGenerator()
    override val itemValue = 30

    override fun describe() {
        this.userPromptGenerator.printText(arrayOf("The Void Cannon is a heavy artillery weapon. Developed by Flux Industries, its the primary weapon " +
                "of most Epoch class ships. Its low reload times, and high damage at short ranges make it a very" +
                "dangerous weapon in close quarter combat.", "Stats:", "Manufactured by: Flux Industries",
                "Damage: ${this.damage} units of armor", "Reload time: 10s",
                "Compatible with the following class of ships: Epoch & Halison"))
    }

    override fun getWeaponName(): String{ return "The Epoch" }

}