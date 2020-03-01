package vehicles

import utils.UserPromptGenerator
import weapons.VoidCannon
import weapons.Weapon


class Epoch(var shipName: String) :Ship(shipName) {

    var weapon: Weapon = VoidCannon()
    private  val userPromptGenerator = UserPromptGenerator()

    private var criticalMultiplier: Double = 0.5

    fun fireWeapons(): Int {
        val weaponDamage: Int = (this.weapon.damage + this.weapon.damage*criticalMultiplier).toInt()
        userPromptGenerator.printText("Firing ${this.weapon.getWeaponName()}." +
                " It does $weaponDamage damage to the enemy's hull. ")
        return weaponDamage
    }

    fun changeWeapon(newWeapon: Weapon){
        this.weapon = newWeapon
    }

}