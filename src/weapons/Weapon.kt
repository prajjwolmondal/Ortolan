package weapons

import utils.UserPromptGenerator

open class Weapon {

    private var userPromptGenerator: UserPromptGenerator = UserPromptGenerator()
    open var damage: Int = 10

    fun upgradeDamage(){if (this.damage < 50) this.damage += 10 else println("Cannot upgrade further")}

    open fun describe(){ userPromptGenerator.printText("This is a generic description of a weapon. Damage done per hit: $damage." +
            "I've forgot to override the describe function if you're seeing this message")}

    open fun getuserPromptGenerator(): UserPromptGenerator{
        return this.userPromptGenerator
    }

}