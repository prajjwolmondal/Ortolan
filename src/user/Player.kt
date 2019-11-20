package user

import utils.UserPromptGenerator
import vehicles.Epoch

class Player constructor(var name: String, val age: Int, var ship: Epoch) {

    var credits: Int = 30
    val userPromptGenerator = UserPromptGenerator()

    fun describeUser() {
        userPromptGenerator.printText("Your name is ${this.name}. You're ${this.age} years old.")
    }

    fun printStats() {
        userPromptGenerator.printText(arrayOf("You've got ${this.credits} credits",
                "You're the captain of the ${this.ship.shipName}"))
    }

    fun retractCredits(retractAmt: Int){
        userPromptGenerator.printText("$retractAmt credits are being retracted from your account")
        this.credits -= retractAmt
    }

    fun addCredits(creditAmt: Int){
        userPromptGenerator.printText("$creditAmt credits are being added to your account")
        this.credits += creditAmt
    }

}