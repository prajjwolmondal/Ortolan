package levels

import user.Player

class Anomaly (playerModel: Player): Level(playerModel) {

    private val anomolyName = "geomagnetic storm"

    init {
        //TODO: Describe arrival at anomaly, followed by description
    }

    override fun getLevelName(): String {
        return this.anomolyName
    }

}