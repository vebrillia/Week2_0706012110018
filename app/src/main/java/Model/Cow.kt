package Model

class Cow( override var id:Int,override var name:String?, override var species:String?,override var age:Int?)
    : Animal(0, "","", 0){
    override var voice: String = "Moooo...."
    override var feed: String = "You feed your cow grass"

}