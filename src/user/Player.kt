package user

import vehicles.Epoch

class Player constructor(var name: String, val age: Int, var ship: Epoch, var credits: Int = 30) {

    fun describeUser() {
        println("Your name is ${this.name}. You're ${this.age} years old.")
    }

    fun printStats() {
        println("You've got ${this.credits} credits")
        println("You're the captain of the ${this.ship.shipName}")
    }

}