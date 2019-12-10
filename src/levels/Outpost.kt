package levels

import user.Player
import weapons.*

class Outpost (private val playerModel: Player): Level(playerModel) {

    private val weaponList: Array<Weapon> = arrayOf(AtlasPlasma(), DoubleBlaster(), Starshatterer(),
                                                    ThermalPhaser(), VoidCannon())
    private val userPromptGenerator = getuserPromptGenerator()

    override fun getLevelName(): String {
        return "Outpost"
    }

    override fun startLevel(levelName: String) {
        this.userPromptGenerator.printText("You arrive at an outpost. You dock the ship and open the trading terminal.")
        this.userPromptGenerator.printText("Outpost trader: Welcome to our humble establishment. " +
                "What's the purpose of your visit?")
        var userResponse = 0
        while (userResponse!=2){
            userResponse = this.userPromptGenerator.getIntResponse(arrayOf("I'm looking to buy",
                    "I'm looking to sell", "<Leave>"))
            when (userResponse){
                0 -> sellItemsToPlay()
                1 -> buyItemsFromPlayer()
            }
            this.userPromptGenerator.printText("Anything else?")
        }
        this.userPromptGenerator.printText("Outpost trader: See ya around!")
    }

    private fun sellItemsToPlay(){
        this.userPromptGenerator.printText("Which item would you like to buy?")
        val userResponse = this.userPromptGenerator.getIntResponse(
                arrayOf(weaponList[0].getWeaponName(), weaponList[1].getWeaponName(), weaponList[2].getWeaponName(),
                        weaponList[3].getWeaponName(), weaponList[4].getWeaponName()))
        when (userResponse){
            0 -> {
                if (this.playerModel.credits>= weaponList[0].itemValue) {
                    this.playerModel.ship.changeWeapon(weaponList[0])
                } else {
                    this.userPromptGenerator.printText("Insufficient funds")
                }
            }
            1 -> {
                if (this.playerModel.credits>= weaponList[1].itemValue) {
                    this.playerModel.ship.changeWeapon(weaponList[1])
                } else {
                    this.userPromptGenerator.printText("Insufficient funds")
                }
            }
            2 -> {
                if (this.playerModel.credits>= weaponList[2].itemValue) {
                    this.playerModel.ship.changeWeapon(weaponList[2])
                } else {
                    this.userPromptGenerator.printText("Insufficient funds")
                }
            }
            3 -> {
                if (this.playerModel.credits>= weaponList[3].itemValue) {
                    this.playerModel.ship.changeWeapon(weaponList[3])
                } else {
                    this.userPromptGenerator.printText("Insufficient funds")
                }
            }
            4 -> {
                if (this.playerModel.credits>= weaponList[4].itemValue) {
                    this.playerModel.ship.changeWeapon(weaponList[4])
                } else {
                    this.userPromptGenerator.printText("Insufficient funds")
                }
            }
        }
    }

    private fun buyItemsFromPlayer(){
        val userResponse = this.userPromptGenerator.getStringInput("Sell your " +
                "${this.playerModel.ship.weapon.getWeaponName()}?(Y/N)", "I ", true)
        when (userResponse) {
            "y" -> {
                this.userPromptGenerator.printText("Amazing, depositing ${this.playerModel.ship.weapon.itemValue} " +
                        "credits into your account now.")
                this.playerModel.addCredits(this.playerModel.ship.weapon.itemValue)
            }
            else -> this.userPromptGenerator.printText("Oookay, fine.")
            }
    }
}