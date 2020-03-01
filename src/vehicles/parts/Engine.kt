package vehicles.parts

import kotlin.random.Random

/**
 * Handles the dodge chances of a ship, and if the ship can move onto the next level.
 *
 */
open class Engine(){

    var numOfEngineDrives: Int = 4

    /**
     * Calculates how likely it is for the ship to dodge the incoming attack based on the engines health
     * @return whether or not the engine helped the ship dodge the incoming attack
     */
    fun dodgedIncomingAttack(): Boolean{
        val dodgeChance = if (Random.nextDouble(0.0,1.0) > 0.5) 1 else 0
        return (numOfEngineDrives > 2) and (dodgeChance==1)
    }

    /**
     * Calculates how likely it is for the ship to leave the current level based on the engines and hull health
     *
     * The ship must have at least 20 hull health to survive the slipspace jump and have 1
     *
     * @return whether or not the ship is able to leave the level
     */
    fun ableToLeaveLevel(hullHealth: Int): Boolean{
        return (numOfEngineDrives > 1) and (hullHealth > 20)
    }

}