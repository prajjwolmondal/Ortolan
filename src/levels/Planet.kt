package levels

import user.Player

class Planet constructor(private val planetName: String, playerModel: Player) : Level(playerModel) {

    override fun getLevelName(): String {
        return this.planetName
    }

    override fun startLevel() {
        val userPromptGenerator = getuserPromptGenerator()
        //TODO: Describe arrival at planet, followed by a random description
        userPromptGenerator.printText("Just about as you complete the jump to $planetName you see that you're facing a Pirate ship")
        userPromptGenerator.printText("Pirates: You're fucking screwed!")
        levelTurn()
    }

}