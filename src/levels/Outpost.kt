package levels

import user.Player

class Outpost (playerModel: Player): Level(playerModel) {

    init {
        //TODO: Describe arrival at outpost, followed by description
    }

    override fun startLevel() {
        val userPromptGenerator = getuserPromptGenerator()
        userPromptGenerator.printText("You arrive at an outpost. You dock the ship and open the trading terminal.")

    }

}