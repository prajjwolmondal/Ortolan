package vehicles

import weapons.Weapon

interface Ship {

    var shipHealth: Int
    var shipClass: String
    var shipShield: Int
    var crewCapacity: Int

    //TODO: Add the weapon vars

    fun takeDamage(damage: Int)

    fun repairShip(repairAmnt: Int)

    fun describeShip()

}