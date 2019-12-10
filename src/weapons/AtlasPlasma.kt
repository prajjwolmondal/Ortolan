package weapons

import utils.UserPromptGenerator

class AtlasPlasma: Weapon{

    override var damage = 20
    override val userPromptGenerator = UserPromptGenerator()
    override val itemValue = 50

    override fun describe() {
        userPromptGenerator.printText(arrayOf("The Atlas Plasma Weapon is a plasma based weapon. " +
                "Developed by The Atlas Corporation, its a weapon favored by a lot of experienced captains. Although" +
                "", "Stats:", "Manufactured by: Flux Industries",
                "Damage: ${this.damage} units of armor", "Reload time: 10s",
                "Compatible with the following class of ships: Epoch & Halison"))
    }

    override fun getWeaponName(): String{ return "The Atlas Plasma Weapon" }

}