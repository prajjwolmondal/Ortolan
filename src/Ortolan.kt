import levels.Intro
import levels.LevelLoader
import user.Player
import utils.*
import vehicles.PlayerShip

fun main(){
    println("Welcome to Ortolan")
    println("This is a science fiction game")
    getPlayerInfo()
}

fun getPlayerInfo(){
    val playerName = getValidString("What would you like to name your character?")
    val playerAge = getValidInt("How old is your character? (0-100)")
    val playerGender = getValidString("What is your gender?")
    val playerShipName = getValidString("What do you want to name your ship?")
    val player = Player(playerName, playerAge, playerGender, PlayerShip(playerShipName))
    player.describeUser()
    player.printStats()
    player.ship.describeShip()
    val levelLoader = LevelLoader()
    levelLoader.runLevel(1)
}