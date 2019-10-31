package weapons

class VoidCannon: Weapon() {

    override fun describe() {
        println("The Void Cannon is a heavy artillery weapon. Developed by Flux Industries, its the primary weapon " +
                "of most Epoch class ships. Its low reload times, and high damage at short ranges make it a very" +
                "dangerous weapon in close quarter combat.")
        println("Stats:")
        println("Manufactured by: Flux Industries")
        println("Damage: ${this.damage} units of armor")
        println("Reload time: 10s")
        println("Compatible with the following class of ships: Epoch & Halison")
    }

}