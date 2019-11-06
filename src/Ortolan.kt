import levels.LevelLoader
import user.Player
import utils.UserPromptGenerator
import vehicles.PlayerShip

val userPromptGenerator = UserPromptGenerator()

fun main(){
    userPromptGenerator.printText("Welcome to Ortolan")
    userPromptGenerator.printText("This is a science fiction game")
    startGame(getPlayerInfo())
}

fun getPlayerInfo(): Player{
    val userPromptGenerator = UserPromptGenerator()
    val playerName = userPromptGenerator.getStringInput("What would you like to name your character?",
        "Enter a name that's not blank. If you can't think of one, use \"dummy\". " +
                "I think it fits your real life character :)")
    val playerAge = userPromptGenerator.getIntResponse("How old is your character? (0-100)",
        "Literally any number between 0 and 100 will do")
    val playerGender = userPromptGenerator.getStringInput("What is your gender?","")
    val playerShipName = userPromptGenerator.getStringInput("What do you want to name your ship?","")
    val player = Player(playerName, playerAge, playerGender, PlayerShip(playerShipName))
    player.describeUser()
    player.printStats()
    player.ship.describeShip()
    return player
}

fun startGame(player: Player){
    val levelLoader = LevelLoader(player)
    levelLoader.runLevel(1)
}