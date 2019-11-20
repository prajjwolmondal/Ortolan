package levels

import user.Player

class Outpost (playerModel: Player): Level(playerModel) {

    override fun getLevelName(): String {
        return "Outpost"
    }

    override fun startLevel(levelName: String) {
        val userPromptGenerator = getuserPromptGenerator()
        userPromptGenerator.printText("You arrive at an outpost. You dock the ship and open the trading terminal.")

    }

}