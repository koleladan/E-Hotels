package com.example.e_hotelsapplication.Data

import android.os.Parcel
import android.os.Parcelable

class Menu() : Parcelable {
    var fimage:String? = null
    var foodname:String? = null
    var price:String? = null

    constructor(parcel: Parcel) : this() {
        fimage = parcel.readString()
        foodname = parcel.readString()
        price = parcel.readString()
    }



    constructor(
        fimage:String?,
        foodname:String?,
        price:String?
    ) : this() {
        this.foodname = foodname
        this.fimage = fimage
        this.price = price
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fimage)
        parcel.writeString(foodname)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Menu> {
        override fun createFromParcel(parcel: Parcel): Menu {
            return Menu(parcel)
        }

        override fun newArray(size: Int): Array<Menu?> {
            return arrayOfNulls(size)
        }
    }
}