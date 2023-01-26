package com.example.e_hotelsapplication.Data

import android.os.Parcel
import android.os.Parcelable

data class RestaurantModel(  val user: User?, ) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readParcelable(User::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(user, flags)
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
        parcel.writeString(fname)
        parcel.writeString(lname)
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

