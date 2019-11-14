package vehicles

import weapons.VoidCannon


class Epoch(var shipName: String) :Ship(shipName) {

    private var weapon: VoidCannon = VoidCannon()

    private var criticalMultiplier: Double = 0.5

    fun fireWeapons(): Int {
        val weaponDamage: Int = (this.weapon.damage + this.weapon.damage*criticalMultiplier).toInt()
        print("Firing the ${this.weapon.getWeaponName()}. It does $weaponDamage damage to the enemy's hull. ")
        return weaponDamage
    }

}