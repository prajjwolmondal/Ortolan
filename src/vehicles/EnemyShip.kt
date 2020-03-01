package vehicles

import utils.UserPromptGenerator
import weapons.VoidCannon
import weapons.Weapon
import kotlin.random.Random

open class EnemyShip(var shipName: String): Ship(shipName, "Enemy") {

    private var weapon: Weapon = VoidCannon()
    private val userPromptGenerator = UserPromptGenerator()

    fun fireWeapons(): Int {
        val luckyMultiplier: Double = if (Random.nextDouble(0.0,1.0) > 0.60) 0.5 else 0.0
        if (luckyMultiplier!=0.0){
            userPromptGenerator.printText("Enemy ship makes a lucky shot. ")
        } else {
            userPromptGenerator.printText("Enemy ship fires at your ship. ")
        }
        return (this.weapon.damage + this.weapon.damage*luckyMultiplier).toInt()
    }

}