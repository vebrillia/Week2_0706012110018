package Model

import android.os.Parcel
import android.os.Parcelable

open class Animal(
    var name:String?,
    var species:String?,
    var age:Int?,
       ) {

    var imageUri: String = ""
    open var voice: String = ""
    open var feed: String = ""
}