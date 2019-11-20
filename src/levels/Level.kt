package levels

import user.Player
import utils.UserPromptGenerator
import vehicles.EnemyShip
import kotlin.system.exitProcess

open class Level(private var playerModel: Player) {

    private var userPromptGenerator: UserPromptGenerator = UserPromptGenerator()
    private lateinit var nextLevel: Level
    private val levelShip: EnemyShip = EnemyShip()

    open fun setNextLevel(level: Level) {
        this.nextLevel = level
    }

    open fun getNextLevel(): Level {
        return this.nextLevel
    }

    open fun getLevelName(): String {
        return "Forgot to override getLevelName()"
    }

    open fun levelTurn(nextLevelName: String) {
        //TODO: Implement the level damages (some will disrupt shield, some will damage hull)

        val playerShip = this.playerModel.ship
        var response: Int = 0

        while ((playerShip.health>0) and (levelShip.getHealth()>0)){
            userPromptGenerator.printText("You can do the following: ")
            response = userPromptGenerator.getIntResponse(arrayOf("Attack enemy ship", "Repair your ship"))
            if (response==0) {
                levelShip.takeDamage(playerShip.fireWeapons())
            }else if (response==666) {
                levelShip.takeDamage(levelShip.getHealth())
            }
            else playerShip.repairShip()
            if (this.levelShip.getHealth() > 0) playerShip.takeDamage(this.levelShip.fireWeapons())
        }
        userPromptGenerator.printText("Congratulations! You've defeated ${this.levelShip.getShipName()}")

        //TODO: Award player rewards for winning battle (fuel & credits)
        awardPlayerRewards()

        userPromptGenerator.printText("What would you like to do to celebrate your victory?")
        response = 1
        while (response!=0){
            response = userPromptGenerator.getIntResponse(arrayOf("Move on", "Repair your ship", "Rename your ship"))
            if (response==1) {
                playerShip.repairShip()
            }
            else if (response==2) {
                val newShipName = userPromptGenerator.getStringInput("What would you like to call your ship?")
                playerShip.renameShip(newShipName)
            }
        }
        userPromptGenerator.printText("You engage your engine drive and head towards $nextLevelName")
    }

    private fun awardPlayerRewards(){
        var creditAwarded = 0
        creditAwarded = if (playerModel.credits <=50) {
            (playerModel.credits * .25).toInt()
        } else {
            (playerModel.credits * .10).toInt()
        }
        playerModel.addCredits(creditAwarded)
        playerModel.ship.modifyFuel(-1)

    }

    open fun getuserPromptGenerator(): UserPromptGenerator{
        return this.userPromptGenerator
    }

    open fun startLevel(levelName: String) {
        this.userPromptGenerator.printText("startLevel() not implemented :(")

    }

    open fun askPlayerForResponse(options: Array<String>): Int {
        return userPromptGenerator.getIntResponse(options)
    }

    open fun gameOver() {
        print("Game over")
        exitProcess(0)
    }


}