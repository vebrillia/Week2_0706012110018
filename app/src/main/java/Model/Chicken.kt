package Model

class Chicken( override var id:Int,override var name:String?, override var species:String?,override var age:Int?)
    : Animal(0, "","", 0){


    override var voice: String = "Petok petok petok.."
    override var feed: String = "You feed your chicken seed"

}