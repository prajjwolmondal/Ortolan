package levels

import user.Player

class Boss (playerModel: Player): Level(playerModel) {

    init {
        //TODO: Describe arrival at boss, followed by description
    }

    override fun levelTurn(nextLevelName: String) {
        super.levelTurn(nextLevelName)
    }
}