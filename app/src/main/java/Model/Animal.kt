package Model

import android.os.Parcel
import android.os.Parcelable

open abstract class Animal(
    open val id:Int, open var name:String?, open var species:String?, open var age:Int?,



       ) {

    var imageUri: String = ""
    open var voice: String = ""
    open var feed: String = ""
}