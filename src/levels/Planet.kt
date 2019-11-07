package levels

import user.Player
import utils.UserPromptGenerator
import kotlin.random.Random

class Planet(playerModel: Player): Level(playerModel) {

    private val planetName: String
    private var planetNames = arrayListOf<String>("Tritan","OA", "Planet J586", "Reach", "Chiron")
    private val userPromptGenerator = UserPromptGenerator()

    private fun getRandomPlanetName(): String{
        val planetIndex =  Random.nextInt(0, planetNames.size)
        val planetName = planetNames[planetIndex]
        planetNames.removeAt(planetIndex)
        return planetName
    }

    override fun getLevelName(): String {
        return this.planetName
    }

    init {
        //TODO: Describe arrival at planet, followed by a random description
        this.planetName = getRandomPlanetName()
    }

}