package levels

import utils.UserPromptGenerator
import kotlin.system.exitProcess

open class Level() {

    private var userPromptGenerator: UserPromptGenerator = UserPromptGenerator()

    open fun startLevel() {
        this.userPromptGenerator.printText("startLevel() not implemented :(")
    }

    open fun askPlayerForResponse(options: Array<String>): Int{
        return userPromptGenerator.getIntResponse(options)
    }

    open fun gameOver(){
        print("Game over")
        exitProcess(0)
    }



}