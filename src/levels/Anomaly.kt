package levels

import user.Player

class Anomaly (playerModel: Player): Level(playerModel) {

    private val anomolyName = "geomagnetic storm"

    override fun startLevel(levelName: String) {
        val userPromptGenerator = getuserPromptGenerator()
        //TODO: Describe arrival at planet, followed by a random description
        userPromptGenerator.printText(arrayOf("Just as you complete the jump to a $anomolyName you see that" +
                " you're facing a Pirate ship", "Pirates: You're fucking screwed!"))
        levelTurn(levelName)
    }

    override fun getLevelName(): String {
        return this.anomolyName
    }
}