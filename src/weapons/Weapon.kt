package weapons

import utils.UserPromptGenerator

interface Weapon {

    val userPromptGenerator: UserPromptGenerator
    var damage: Int
    val itemValue: Int

    fun upgradeDamage(){if (this.damage < 50) this.damage += 10 else println("Cannot upgrade further")}

    fun describe()

    fun getWeaponName(): String

}