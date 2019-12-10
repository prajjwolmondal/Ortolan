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

        var response: Int = 0
        this.playerModel.ship.modifyFuel(-1)

        while ((this.playerModel.ship.health>0) and (this.levelShip.health>0)){
            userPromptGenerator.printText("You can do the following: ")
            response = userPromptGenerator.getIntResponse(arrayOf("Attack enemy ship", "Repair your ship"))
            if (response==0) {
                this.levelShip.takeDamage(this.playerModel.ship.fireWeapons())
            }
            else this.playerModel.ship.repairShip()
            if (this.levelShip.health > 0) this.playerModel.ship.takeDamage(this.levelShip.fireWeapons())
        }
        userPromptGenerator.printText("Congratulations! You've defeated ${this.levelShip.getShipName()}")
        endLevel(nextLevelName)
    }

    open fun endLevel(nextLevelName: String){
        awardPlayerRewards()
        userPromptGenerator.printText("What would you like to do to celebrate your victory?")
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
    }

    private fun awardPlayerRewards(){
        var creditAwarded = 0
        creditAwarded = if (this.playerModel.credits <=50) {
            (this.playerModel.credits * .25).toInt()
        } else {
            (this.playerModel.credits * .10).toInt()
        }
        this.playerModel.addCredits(creditAwarded)
    }

    open fun getuserPromptGenerator(): UserPromptGenerator{
        return this.userPromptGenerator
    }

    open fun startLevel(nextLevelName: String) {
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