package Model

class Cow(name: String?, species: String?, age: Int?) :Animal(name, species, age) {
    override var voice: String = "Moooo...."
    override var feed: String = "You feed your cow grass"

}