package com.example.e_hotelsapplication.Data

import android.os.Parcel
import android.os.Parcelable

data class RestaurantModel( val name:String?, val address:String?, val delivery_charge:String?,
val image:String?, val hours: Hours?, val register: Register?, val user: User?, val menus: List<Menus?>?) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Hours::class.java.classLoader),
        parcel.readParcelable(Register::class.java.classLoader),
        parcel.readParcelable(User::class.java.classLoader),
        parcel.createTypedArrayList(Menus)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(delivery_charge)
        parcel.writeString(image)
        parcel.writeParcelable(hours, flags)
        parcel.writeParcelable(register, flags)
        parcel.writeParcelable(user, flags)
        parcel.writeTypedList(menus)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RestaurantModel> {
        override fun createFromParcel(parcel: Parcel): RestaurantModel {
            return RestaurantModel(parcel)
        }

        override fun newArray(size: Int): Array<RestaurantModel?> {
            return arrayOfNulls(size)
        }
    }

}

data class Hours(val Sunday:String?, val Monday:String?, val Tuesday:String?,val Wednesday:String?,
val Thursday:String?, val Friday:String?, val Saturday:String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Sunday)
        parcel.writeString(Monday)
        parcel.writeString(Tuesday)
        parcel.writeString(Wednesday)
        parcel.writeString(Thursday)
        parcel.writeString(Friday)
        parcel.writeString(Saturday)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hours> {
        override fun createFromParcel(parcel: Parcel): Hours {
            return Hours(parcel)
        }

        override fun newArray(size: Int): Array<Hours?> {
            return arrayOfNulls(size)
        }
    }
}

data class Menus( val name: String?, val price:Float, val url:String?, val totalInCart:Int) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeFloat(price)
        parcel.writeString(url)
        parcel.writeInt(totalInCart)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Menus> {
        override fun createFromParcel(parcel: Parcel): Menus {
            return Menus(parcel)
        }

        override fun newArray(size: Int): Array<Menus?> {
            return arrayOfNulls(size)
        }
    }
}
data class Register(val customer: String?, val restaurant: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(customer)
        parcel.writeString(restaurant)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Register> {
        override fun createFromParcel(parcel: Parcel): Register {
            return Register(parcel)
        }

        override fun newArray(size: Int): Array<Register?> {
            return arrayOfNulls(size)
        }
    }

}
data class  User(val fname:String?, val lname:String?,val email:String?, val pin:String?,val confirm:String?) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(lname)
        parcel.writeString(fname)
        parcel.writeString(email)
        parcel.writeString(pin)
        parcel.writeString(confirm)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
