package levels

import user.Player
import utils.UserPromptGenerator
import kotlin.system.exitProcess

open class Level(playerModel: Player) {

    private var userPromptGenerator: UserPromptGenerator = UserPromptGenerator()
    private lateinit var nextLevel: Level

    open fun setNextLevel(level: Level){
        this.nextLevel = level
    }

    open fun getNextLevel(): Level{
        return this.nextLevel
    }

    open fun getLevelName(): String{return "Forgot to override getLevelName()"}

    open fun levelTurn(){
        //TODO: Implement the level turn (some will disrupt shield, some will damage hull)
    }

    open fun startLevel() {
        this.userPromptGenerator.printText("startLevel() not implemented :(")
    }

    open fun askPlayerForResponse(options: Array<String>): Int{
        return userPromptGenerator.getIntResponse(options)
    }

    open fun printText(input: String){
        userPromptGenerator.printText(input)
    }

    open fun printText(inputs: Array<String>){
        userPromptGenerator.printText(inputs)
    }

    open fun gameOver(){
        print("Game over")
        exitProcess(0)
    }



}