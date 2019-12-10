package levels

import user.Player
import utils.UserPromptGenerator
import java.io.File

class LevelLoader(private var playerModel: Player) {

    private val introLvl = Intro(this.playerModel)
    private var planets = returnPlanets()
    private val userPromptGenerator = UserPromptGenerator()

    private fun returnPlanets(): MutableList<Planet>{
        val planetFileReader = File("src/levels/resources/PlanetInfo.txt").bufferedReader()
        val planetList: MutableList<Planet> = mutableListOf()
        planetFileReader.forEachLine {line ->
            val planetInfo = line.split(";")
            planetList.add(Planet(planetInfo[0], planetInfo[1], planetInfo[2], this.playerModel))
        }
        return planetList
    }

    fun runLevels(){

        // TODO: Move planet initialization to individual Level level with each level running the next level
        val outpost = Outpost(this.playerModel)
        this.introLvl.startLevel(outpost.getLevelName())
        when (getPlayersNextMove(planets[0], planets[1])){
            0 -> planets[0].startLevel(outpost.getLevelName())
            1 -> planets[1].startLevel(outpost.getLevelName())
        }
        outpost.startLevel(outpost.getLevelName())
        val anomaly = Anomaly(this.playerModel)
        val astroidBelt = AsteroidBelt(this.playerModel)
        when (getPlayersNextMove(anomaly, astroidBelt)){
            0 -> anomaly.startLevel(outpost.getLevelName())
            1 -> astroidBelt.startLevel(outpost.getLevelName())
        }
        outpost.startLevel(outpost.getLevelName())
        //TODO: Fix bug where the last two planets starts but game is over after opening blurb
        when (getPlayersNextMove(planets[2], planets[3])){
            0 -> planets[2].startLevel(outpost.getLevelName())
            1 -> planets[3].startLevel(outpost.getLevelName())
        }
        outpost.startLevel(outpost.getLevelName())
        val boss = Boss(this.playerModel)
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