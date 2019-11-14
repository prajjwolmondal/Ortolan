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

    open fun levelTurn() {
        //TODO: Implement the level damages (some will disrupt shield, some will damage hull)

        val playerShip = this.playerModel.ship
        while ((playerShip.health>0) and (levelShip.getHealth()>0)){
            userPromptGenerator.printText("You can do the following: ")
            val response = userPromptGenerator.getIntResponse(arrayOf("Attack enemy ship", "Repair your ship"))
            if (response==0) levelShip.takeDamage(playerShip.fireWeapons()) else playerShip.repairShip()
            if (levelShip.getHealth() > 0) playerShip.takeDamage(levelShip.fireWeapons())
        }

        //TODO: Award player rewards for winning battle (fuel & credits)

    }

    open fun getuserPromptGenerator(): UserPromptGenerator{
        return this.userPromptGenerator
    }

    open fun startLevel() {
        this.userPromptGenerator.printText("startLevel() not implemented :(")

    }

    open fun askPlayerForResponse(options: Array<String>): Int {
        return userPromptGenerator.getIntResponse(options)
    }

    open fun printText(input: String) {
        userPromptGenerator.printText(input)
    }

    open fun printText(inputs: Array<String>) {
        userPromptGenerator.printText(inputs)
    }

    open fun gameOver() {
        print("Game over")
        exitProcess(0)
    }


}