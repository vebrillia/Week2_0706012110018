package Model

class Goat( override var id:Int,override var name:String?, override var species:String?,override var age:Int?)
    : Animal(0, "","", 0){
    override var voice: String = "Embeee mbeee...."
    override var feed: String = "You feed your goat grass"

}
