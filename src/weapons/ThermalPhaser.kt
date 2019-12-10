package weapons

import utils.UserPromptGenerator

class ThermalPhaser: Weapon{

    override var damage = 10
    override val userPromptGenerator = UserPromptGenerator()
    override val itemValue = 30

    override fun describe() {
        userPromptGenerator.printText(arrayOf("The Thermal Phaser is a high speed phaser weapon that utilzes the " +
                "ships thermal output to boost its power and lower reload time. Its often used by pirate ships who " +
                "keep their ships pretty hot.", "Stats:", "Manufactured by: <Unknown>",
                "Damage: ${this.damage} units of armor", "Reload time: 5s",
                "Compatible with the following class of ships: Epoch & Halison"))
    }

    override fun getWeaponName(): String{ return "The Thermal Phaser" }

}