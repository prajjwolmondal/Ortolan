package levels

import user.Player

class Intro(player: Player) : Level() {

    var playerModel: Player = player

    override fun startLevel() {
        println("You open the door to you helm and head for the mainframe. You enter your credentials. " +
                "It accepts and logs you in.")
        println("\"You have a new high priority mission from the Expom Command\" it lets you know. " +
                "You go to your event log and open the transmission.")
        println("${this.playerModel.name} you have been tasked with the delivery of package #A190-13. The contents are" +
                "very valuable and classified. You will be rewarded with 100,000,000 in credits upon delivery. We've" +
                "deposited 5,000 credits as an advance on the payment. Please open your dock to accept the package." +
                "Remember that denying of this mission will result in 3 demerit points against your licence.")
        val playerInput: Int
        val questions = arrayOf("Accept the mission", "I don't need this shit. Find someone else")
        playerInput = askPlayerForResponse(questions)
        if (playerInput==1){

            gameOver()
        } else {
            println("<Opening dock>")
            println("You: What's the destination? ")
            println("Expom Command: The Aurora station. We have uploaded the safest possible navigation routes to " +
                    "your mainframe. As stated earlier, the remaining 999,995,000 credits will be deposited into" +
                    "your account upon delivery of the package.")
        }
    }



}