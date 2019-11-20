package levels

import user.Player
import utils.UserPromptGenerator
import kotlin.random.Random

class LevelLoader(player: Player) {

    private var playerModel: Player = player
    private val introLvl = Intro(playerModel)
    private var planetNames = arrayListOf<String>("Tritan","OA", "Planet J586", "Reach", "Chiron")
    private val userPromptGenerator = UserPromptGenerator()

    private fun getRandomPlanetName(): String{
        val planetIndex =  Random.nextInt(0, planetNames.size)
        val planetName = planetNames[planetIndex]
        planetNames.removeAt(planetIndex)
        return planetName
    }

    fun runLevels(){

        // TODO: Move planet initialization to individual Level level with each level running the next level
        val planet1a = Planet(getRandomPlanetName(), playerModel)
        val planet1b = Planet(getRandomPlanetName(), playerModel)
        val outpost = Outpost(playerModel)
        val anomaly = Anomaly(playerModel)
        val astroidBelt = AstroidBelt(playerModel)
        val planet2a = Planet(getRandomPlanetName(), playerModel)
        val planet2b = Planet(getRandomPlanetName(), playerModel)
        val boss = Boss(playerModel)
        this.introLvl.startLevel(outpost.getLevelName())
        when (getPlayersNextMove(planet1a, planet1b)){
            0 -> planet1a.startLevel(outpost.getLevelName())
            1 -> planet1b.startLevel(outpost.getLevelName())
        }
        outpost.startLevel(outpost.getLevelName())
        when (getPlayersNextMove(anomaly, astroidBelt)){
            0 -> anomaly.startLevel(outpost.getLevelName())
            1 -> astroidBelt.startLevel(outpost.getLevelName())
        }
        outpost.startLevel(outpost.getLevelName())
        when (getPlayersNextMove(planet2a, planet2b)){
            0 -> planet2a.startLevel(outpost.getLevelName())
            1 -> planet2b.startLevel(outpost.getLevelName())
        }
        outpost.startLevel(outpost.getLevelName())
        boss.startLevel(outpost.getLevelName())
    }

    private fun getPlayersNextMove(option1: Level, option2: Level): Int{
        return if ((option1.getLevelName()=="geomagnetic storm") or (option2.getLevelName()=="asteroid belt")){
            this.userPromptGenerator.getIntResponse(arrayOf("Go to the ${option1.getLevelName()}?",
                "Go to the ${option2.getLevelName()}?"))
        } else {
            this.userPromptGenerator.getIntResponse(arrayOf("Go to Planet ${option1.getLevelName()}?",
                "Go to Planet ${option2.getLevelName()}?"))
        }
    }
}