package levels

import user.Player

class AstroidBelt(playerModel: Player) : Level(playerModel) {

    private val astroidBeltName = "asteroid belt"

    init {
        //TODO: Describe arrival at astroid belt, followed by description
    }

    override fun getLevelName(): String {
        return this.astroidBeltName
    }

}