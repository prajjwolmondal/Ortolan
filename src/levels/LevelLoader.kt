package levels

import user.Player
import utils.UserPromptGenerator

class LevelLoader(player: Player) {

    private var playerModel: Player = player
    private val introLvl = Intro(playerModel)
    private val planet1a = Planet(playerModel)
    private val planet1b = Planet(playerModel)
    private val outpost = Outpost(playerModel)
    private val anomaly = Anomaly(playerModel)
    private val astroidBelt = AstroidBelt(playerModel)
    private val planet2a = Planet(playerModel)
    private val planet2b = Planet(playerModel)
    private val boss = Boss(playerModel)
    private val userPromptGenerator = UserPromptGenerator()

    fun runLevels(){
        this.introLvl.startLevel()
        when (getPlayersNextMove(planet1a, planet1b)){
            1 -> planet1a.startLevel()
            2 -> planet1b.startLevel()
        }
        outpost.startLevel()
        when (getPlayersNextMove(anomaly, astroidBelt)){
            1 -> anomaly.startLevel()
            2 -> astroidBelt.startLevel()
        }
        when (getPlayersNextMove(planet2a, planet2b)){
            1 -> planet2a.startLevel()
            2 -> planet2b.startLevel()
        }
        outpost.startLevel()
        boss.startLevel()
    }

    private fun getPlayersNextMove(option1: Level, option2: Level): Int{
        if ((option1.getLevelName()=="Geomagnetic Storm") or (option2.getLevelName()=="Asteroid Belt")){
            this.userPromptGenerator.printText(arrayOf("Go to the ${option1.getLevelName()}?",
                "Go to the ${option1.getLevelName()}?"))
        } else {
            this.userPromptGenerator.printText(arrayOf("Go to Planet ${option1.getLevelName()}?",
                "Go to Planet ${option1.getLevelName()}?"))
            }
        return this.userPromptGenerator.getIntResponse()
    }
}