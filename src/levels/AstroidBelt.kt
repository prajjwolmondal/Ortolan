package levels

import user.Player
import utils.UserPromptGenerator
import vehicles.EnemyShip
import kotlin.random.Random

class AstroidBelt(private val playerModel: Player) : Level(playerModel) {

    private val astroidBeltName = "asteroid belt"
    private var userPromptGenerator: UserPromptGenerator = UserPromptGenerator()
    private val levelShip: EnemyShip = EnemyShip()

    override fun startLevel(levelName: String) {
        val userPromptGenerator = getuserPromptGenerator()
        //TODO: Describe arrival at planet, followed by a random description
        userPromptGenerator.printText(arrayOf("You arrive at an $astroidBeltName. The asteroids are accompanied by " +
                "destroyed ships on its journey around its nearby star. As you navigate the belt, you're hailed by a " +
                "pirate ship.", "Pirates: You're fucking screwed!"))
        this.levelTurn(levelName)
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
        this.userPromptGenerator.printText("Congratulations! You've defeated ${this.levelShip.getShipName()}")
        endLevel(nextLevelName)
    }

    private fun levelDamage(){
        if (Random.nextInt(0, 100)>60) {
            val levelDamageAmt = 20
            this.playerModel.ship.health -= levelDamageAmt
            this.levelShip.health -= levelDamageAmt
            this.userPromptGenerator.printText(arrayOf("The $astroidBeltName causes a short circuit of both your and the " +
                    "enemy ship, resulting in $levelDamageAmt in damage to the hull.", "Your ship health: " +
                    "${this.playerModel.ship.health} and ${this.levelShip.getShipName()} " +
                    "health: ${this.levelShip.health}"))
        }
    }

    override fun getLevelName(): String {
        return this.astroidBeltName
    }

}