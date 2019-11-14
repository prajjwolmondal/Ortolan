package vehicles

import kotlin.random.Random

open class Ship( private var shipName: String, private var shipClass: String = "Epoch") {

    var health: Int = 100
    var shieldCapacity: Int = 100
    var fuelLeft: Int = 3

    private var licenceNum: String = "XTNT40-1E"
    private var repairAmnt: Int = 10
    private var crewCount: Int = 1

    //TODO: Add the weapon vars

    fun takeDamage(damage: Int) {
        this.health -= damage
        if (this.health <= 0) {
            println(
                    "The last shot ruptures the engine drive causing an explosion to rupture through the " +
                            "${this.shipName}. Game over."
            )
        } else {
            println("${this.shipName} health is now at: ${this.health}")
        }
    }

    fun repairShip() {
        this.health += this.repairAmnt
        if (this.health > 100) this.health = 100
        println("Ship health is now at: ${this.health}")
    }

    fun renameShip(newName: String) {
        this.shipName = newName
        println("You've renamed your ship to - ${this.shipName}")
    }

    fun changeLicencePlate() {
        val randomNumber = Random.nextInt(10, 99)
        val randomEndNumber = Random.nextInt(0, 9)
        this.licenceNum = "XTNT$randomNumber-$randomEndNumber E"
    }

    fun describeShip() {
        when (this.shipClass) {
            "Halison" -> println()
            "Poseidon" -> println()
            "Shiva" -> println()
            else -> {
                println(
                        "You own the ${this.shipName}. A ${this.shipClass} class vehicle. Its got one main engine, and " +
                                "one main artillery cannon. Its got rooms for a 4 person crew, although you could probably " +
                                "squeeze in about 10. The ships licence number is: ${this.licenceNum}"
                )
            }
        }
    }

}