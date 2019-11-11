package vehicles

import weapons.VoidCannon
import weapons.Weapon


class Epoch(var shipName: String) :Ship(shipName) {

    private var weapon: Weapon = VoidCannon()

    private var criticalMultiplier: Double = 0.5

    fun fireWeapons(): Int {
        println("Firing weapon")
        return (this.weapon.damage + this.weapon.damage*criticalMultiplier).toInt()
    }

}