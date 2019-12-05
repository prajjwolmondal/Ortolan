package vehicles

import utils.UserPromptGenerator
import kotlin.random.Random
import kotlin.system.exitProcess

open class Ship( private var shipName: String, private var shipClass: String = "Epoch") {

    var health: Int = 100
    var shieldCapacity: Int = 100

    private var fuelLeft: Int = 3
    private var licenceNum: String = "XTNT40-1E"
    private var repairAmnt: Int = 10
    private var crewCount: Int = 1
    private val userPromptGenerator = UserPromptGenerator()

    //TODO: Add the weapon vars

    fun takeDamage(damage: Int) {
        this.health -= damage
        if (this.health <= 0) {
            userPromptGenerator.printText(
                    "The last shot ruptures your engine drive, causing an explosion to rupture through the " +
                            "${this.shipName}."
            )
        } else {
            userPromptGenerator.printText("${this.shipName} health is now at: ${this.health}")
        }
    }

    fun modifyFuel(modifyAmt: Int){
        val fuelAwardedChance = Random.nextInt(0,10)
        if (modifyAmt >= 0) {
            if ((fuelAwardedChance > 8) and (this.fuelLeft <= 2)) {
                this.fuelLeft = if (this.fuelLeft + modifyAmt > 3) {
                    3
                } else {
                    this.fuelLeft + modifyAmt
                }
            userPromptGenerator.printText("You have ${this.fuelLeft} fuel left")
            }
        } else {
            if (this.fuelLeft+modifyAmt <= 0){
                gameOver()
            }
            this.fuelLeft += modifyAmt
        }
    }

    fun repairShip() {
        this.health += this.repairAmnt
        if (this.health > 100) this.health = 100
        userPromptGenerator.printText("Ship health is now at: ${this.health}")
    }

    fun renameShip(newName: String) {
        this.shipName = newName
        userPromptGenerator.printText("You've renamed your ship to - ${this.shipName}")
    }

    fun changeLicencePlate() {
        val randomNumber = Random.nextInt(10, 99)
        val randomEndNumber = Random.nextInt(0, 9)
        this.licenceNum = "XTNT$randomNumber-$randomEndNumber E"
    }

    private fun gameOver() {
        print("Game over")
        exitProcess(0)
    }

    fun describeShip() {
        when (this.shipClass) {
            "Halison" -> println()
            "Poseidon" -> println()
            "Shiva" -> println()
            else -> {
                userPromptGenerator.printText(
                        "You own the ${this.shipName}. A ${this.shipClass} class vehicle. Its got one main engine, and " +
                                "one main artillery cannon. Its got rooms for a 4 person crew, although you could probably " +
                                "squeeze in about 10. The ships licence number is: ${this.licenceNum}"
                )
            }
        }
    }

}