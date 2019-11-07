package levels

import user.Player
import utils.UserPromptGenerator

class Planet constructor(private val planetName: String, playerModel: Player): Level(playerModel) {

    private val userPromptGenerator = UserPromptGenerator()

    override fun getLevelName(): String {
        return this.planetName
    }

    init {
        //TODO: Describe arrival at planet, followed by a random description
    }

}