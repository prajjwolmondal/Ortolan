package levels

import user.Player
import utils.UserPromptGenerator
import vehicles.EnemyShip
import kotlin.random.Random

class AsteroidBelt(private val playerModel: Player) : Level(playerModel) {

    private val asteroidBeltName = "asteroid belt"
    private var userPromptGenerator: UserPromptGenerator = UserPromptGenerator()
    private val levelShip: EnemyShip = EnemyShip("ASTROTHUNDER")

    override fun startLevel(nextLevelName: String) {
        val userPromptGenerator = getuserPromptGenerator()
        var response = 0
        this.playerModel.ship.modifyFuel(-1)
        userPromptGenerator.printText(arrayOf("You arrive at an $asteroidBeltName. The asteroids are accompanied by " +
                "destroyed ships on its journey around its star. As you navigate the belt, you're hailed by a " +
                "pirate ship.", "Pirates: We won't smash your ship against all these rocks if you pay us 30 credits"))
        if (playerModel.credits >= 30) {
            if (userPromptGenerator.getIntResponse(arrayOf("Pay the fine", "Fuck outta here, dumb dumb no get my money"))==0){
                playerModel.retractCredits(-30)
                var response:Int = 1
                while (response!=0){
                    response = userPromptGenerator.getIntResponse(arrayOf("Move on", "Repair your ship", "Rename your ship"))
                    if (response==1) {
                        this.playerModel.ship.repairShip()
                    }
                    else if (response==2) {
                        val newShipName = userPromptGenerator.getStringInput("What would you like to call your ship?")
                        this.playerModel.ship.renameShip(newShipName)
                    }
                }
                userPromptGenerator.printText("You engage your engine drive and head towards $nextLevelName")
            } else {
                userPromptGenerator.printText("I WILL END YOU!")
                this.levelTurn(nextLevelName)
            }
        } else {
            userPromptGenerator.getIntResponse(arrayOf("I don't have that many credits",
                    "Hahaha, you really think I'd be here in this shit-hole if I had that kind of money"))
            userPromptGenerator.printText("You're fucked then")
            this.levelTurn(nextLevelName)
        }
    }

    override fun levelTurn(nextLevelName: String) {
        var response: Int = 0
        while ((this.playerModel.ship.health>0) and (levelShip.health>0)){
            this.userPromptGenerator.printText("You can do the following: ")
            response = this.userPromptGenerator.getIntResponse(arrayOf("Attack enemy ship", "Repair your ship"))
            if (response==0) {
                levelShip.takeDamage(this.playerModel.ship.fireWeapons())
            }
            else this.playerModel.ship.repairShip()
            this.playerModel.ship.takeDamage(this.levelShip.fireWeapons())
            levelDamage()
        }
        this.userPromptGenerator.printText("Congratulations! You've defeated ${this.levelShip.shipName}")
        endLevel(nextLevelName)
    }

    private fun levelDamage(){
        if (Random.nextInt(0, 100)>60) {
            val levelDamageAmt = 20
            this.playerModel.ship.health -= levelDamageAmt
            this.levelShip.health -= levelDamageAmt
            this.userPromptGenerator.printText(arrayOf("The $asteroidBeltName causes a short circuit of both your and the " +
                    "enemy ship, resulting in $levelDamageAmt in damage to the hull.", "Your ship health: " +
                    "${this.playerModel.ship.health} and ${this.levelShip.shipName} " +
                    "health: ${this.levelShip.health}"))
        }
    }

    override fun getLevelName(): String {
        return this.asteroidBeltName
    }

}