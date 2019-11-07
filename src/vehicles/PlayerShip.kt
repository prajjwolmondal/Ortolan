package vehicles

import weapons.VoidCannon
import weapons.Weapon
import kotlin.random.Random


class PlayerShip constructor(var shipName: String,  var shipLicenceNum: String = "XTNT40-1E",
                             private var shipFuel: Int = 3, override var shipClass: String = "Epoch",
                             override var shipHealth: Int = 100, override var shipShield: Int = 50,
                             override var crewCapacity: Int = 2): Ship {

    private var weapon: Weapon = VoidCannon()

    init {
        when (this.shipClass){
            "Halison" -> {
                this.crewCapacity = 3
            }
            "Poseidon" -> {
                this.crewCapacity = 3
            }
            "Shiva" -> {
                this.crewCapacity = 6
            }
        }
    }

    override fun takeDamage(damage: Int) {
        this.shipHealth -= damage
        if (this.shipHealth<=0){
            println("The last shot ruptures the engine driver causing an explosion to rupture through the " +
                    "${this.shipName}. Game over.")
        } else {
            println("Ship health is now at: ${this.shipHealth}")
        }
    }

    override fun repairShip(repairAmnt: Int) {
        this.shipHealth += repairAmnt
        if (this.shipHealth > 100) this.shipHealth = 100
        println("Ship health is now at: ${this.shipHealth}")
    }

    fun renameShip(newName: String) {
        this.shipName = newName
        println("You've renamed your ship to - ${this.shipName}")
    }

    fun changeLicencePlate() {
        val randomNumber = Random.nextInt(10, 99)
        val randomEndNumber = Random.nextInt(0, 9)
        this.shipLicenceNum = "XTNT$randomNumber-$randomEndNumber E"
    }

    override fun describeShip() {
        when (this.shipClass) {
            "Halison" -> println()
            "Poseidon" -> println()
            "Shiva" -> println()
            else -> {
                println(
                    "You own the ${this.shipName}. A ${this.shipClass} class vehicle. Its got one main engine, and " +
                            "one main artillery cannon. Its got rooms for a 4 person crew, although you could probably " +
                            "squeeze in about 10. The ships licence number is: ${this.shipLicenceNum}"
                )
            }
        }
    }
}