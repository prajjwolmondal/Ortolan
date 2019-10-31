package weapons

open class Weapon {

    var damage: Int = 10

    fun upgradeDamage(){if (this.damage < 50) this.damage += 10 else println("Cannot upgrade further")}

    open fun describe(){ println("This is a generic description of a weapon. Damage done per hit: $damage." +
            "I've forgot to override the describe function if you're seeing this message")}

}