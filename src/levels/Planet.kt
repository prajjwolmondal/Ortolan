package levels

import user.Player

class Planet constructor(private val planetName: String, private val playerModel: Player) : Level(playerModel) {

    override fun getLevelName(): String {
        return this.planetName
    }

    override fun startLevel(levelName: String) {
        val userPromptGenerator = getuserPromptGenerator()
        //TODO: Describe arrival at planet, followed by a random description
        userPromptGenerator.printText(arrayOf("Just as you complete the jump to $planetName you see that " +
                "you're facing a Pirate ship", "Pirates: You're fucking screwed!"))
        levelTurn(levelName)
    }

}