package levels

class Intro: Level{
    override fun allPossibleLevels(): List<Int> {
        return listOf(1,2)
    }

    init {
        println()
    }

}