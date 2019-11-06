package levels

import user.Player

class LevelLoader(player: Player) {

    private lateinit var levelList: MutableList<Level>
    private var playerModel: Player = player

    init {
        val introLvl = Intro(playerModel)
        levelList = mutableListOf<Level>()
        levelList.add(introLvl)
    }

    fun runLevel(levelID: Int){
        val playerLevel: Level
        when (levelID){
            1 -> {
                playerLevel = levelList[0]
                playerLevel.startLevel()
            }
        }
    }

}