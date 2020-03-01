package levels

import user.Player
import utils.UserPromptGenerator
import vehicles.EnemyShip
import kotlin.random.Random

class Anomaly (private val playerModel: Player): Level(playerModel) {

    private val anomolyName = "geomagnetic storm"
    private var userPromptGenerator: UserPromptGenerator = UserPromptGenerator()
    private val levelShip: EnemyShip = EnemyShip("Firestarter")

    override fun startLevel(nextLevelName: String) {
        val userPromptGenerator = getuserPromptGenerator()
        userPromptGenerator.printText(arrayOf("You arrive at a $anomolyName. You notice that the storm is messing up " +
                "ships electrical system. Luckily your systems seem to withstanding it for now. You get pinged by an" +
                "incoming ship", "Pirates: What a fucking terrible mistake you made coming here"))
        this.levelTurn(nextLevelName)
    }

    override fun levelTurn(nextLevelName: String) {
        var response: Int = 0
        this.playerModel.ship.modifyFuel(-1)

        while ((this.playerModel.ship.health>0) and (levelShip.health>0)){
            this.userPromptGenerator.printText("You can do the following: ")
            response = this.userPromptGenerator.getIntResponse(arrayOf("Attack enemy ship", "Repair your ship"))
            if (response==0) {
                levelShip.takeDamage(this.playerModel.ship.fireWeapons())
            }
            else this.playerModel.ship.repairShip()
            this.playerModel.ship.takeDamage(this.levelShip.fireWeapons())
            levelDamage()
        }
        this.userPromptGenerator.printText("Congratulations! You've defeated ${this.levelShip.shipName}")
        endLevel(nextLevelName)
    }

    private fun levelDamage(){
        if (Random.nextInt(0, 100)>60) {
            val levelDamageAmt = 20
            this.playerModel.ship.health -= levelDamageAmt
            this.levelShip.health -= levelDamageAmt
            this.userPromptGenerator.printText(arrayOf("The $anomolyName causes a short circuit of both your and the " +
                    "enemy ship, resulting in $levelDamageAmt in damage to the hull.", "Your ship health: " +
                    "${this.playerModel.ship.health} and ${this.levelShip.shipName} " +
                    "health: ${this.levelShip.health}"))
        }
    }

    override fun getLevelName(): String {
        return this.anomolyName
    }
}