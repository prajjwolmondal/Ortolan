package user

import vehicles.PlayerShip

class Player constructor(var name: String, val age: Int, var gender: String, var ship: PlayerShip, var credits: Int = 30) {

    fun describeUser() {
        println("Your name is ${this.name}. You're ${this.age} years old and you're a ${this.gender}")
    }

    fun printStats() {
        println("You've got ${this.credits} credits")
        println("You're the captain of the ${this.ship.shipName}")
    }

}