package levels

class LevelLoader {

    fun runLevel(levelID: Int){
        when (levelID){
            1 -> runIntro()
        }
    }

    private fun runIntro() {
        Intro()
    }

}