package Model

class Chicken(name: String?, species: String?, age: Int?) :Animal(name, species, age ) {
    override var voice: String = "Petok petok petok.."
    override var feed: String = "You feed your chicken seed"

}