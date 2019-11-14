package weapons

class VoidCannon: Weapon() {

    private var userPromptGenerator = getuserPromptGenerator()

    override fun describe() {
        userPromptGenerator.printText(arrayOf("The Void Cannon is a heavy artillery weapon. Developed by Flux Industries, its the primary weapon " +
                "of most Epoch class ships. Its low reload times, and high damage at short ranges make it a very" +
                "dangerous weapon in close quarter combat.", "Stats:", "Manufactured by: Flux Industries",
                "Damage: ${this.damage} units of armor", "Reload time: 10s",
                "Compatible with the following class of ships: Epoch & Halison"))
    }

    fun getWeaponName(): String{
        return "Epoch"
    }

}