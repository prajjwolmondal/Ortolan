package weapons

class AtlasPlasma: Weapon() {

    val userPromptGenerator = getuserPromptGenerator()
    override var damage = 20;

    override fun describe() {
        userPromptGenerator.printText(arrayOf("The Atlas Plasma Weapon is a plasma based weapon. " +
                "Developed by The Atlas Corporation, its a weapon favored by a lot of experienced captains. Although" +
                "", "Stats:", "Manufactured by: Flux Industries",
                "Damage: ${this.damage} units of armor", "Reload time: 10s",
                "Compatible with the following class of ships: Epoch & Halison"))
    }

    fun getWeaponName(): String{
        return "The Atlas Plasma Weapon"
    }

}