package com.example.e_hotelsapplication.Data

import android.os.Parcel
import android.os.Parcelable

class RestaurantListData() : Parcelable {
     var menu:Menu? = null
    var name:String? = null
    var address:String? =null
    var image:String?= null
     var hours:Hours? =null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        address = parcel.readString()
        image = parcel.readString()
    }

    constructor(
        menu: Menu?,
        name:String?,
        address:String?,
        image:String?,
        hours: Hours?,

    ) : this() {
        this.menu = menu
        this.name = name
        this.address = address
        this.image = image
        this.hours =hours
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RestaurantListData> {
        override fun createFromParcel(parcel: Parcel): RestaurantListData {
            return RestaurantListData(parcel)
        }

        override fun newArray(size: Int): Array<RestaurantListData?> {
            return arrayOfNulls(size)
        }
    }

}

