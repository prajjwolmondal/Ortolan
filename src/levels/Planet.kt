package levels

import user.Player

class Planet constructor(private val planetName: String, private val planetPopulation: String,
                         private val planetDescription: String, private val playerModel: Player) : Level(playerModel) {

    override fun getLevelName(): String {
        return this.planetName
    }

    override fun startLevel(nextLevelName: String) {
        val userPromptGenerator = getuserPromptGenerator()
        userPromptGenerator.printText(arrayOf("You complete your jump to ${this.planetName} without any issues.",
                this.planetDescription, "Population: "+this.planetPopulation))
        this.levelTurn(nextLevelName)
    }

}