package com.example.e_hotelsapplication.Data

import android.os.Parcel
import android.os.Parcelable


class Restaurant() : Parcelable {
    var address: String? = null
    var image: String? = null
    var name: String? = null
    var menu:Map<String, Menu>? = null

    constructor(parcel: Parcel) : this() {
        address = parcel.readString()
        image = parcel.readString()
        name = parcel.readString()
    }


    constructor(address: String?, image: String?,name: String?, menu:Map<String, Menu>?) : this() {
        this.address = address
        this.image = image
        this.name = name
        this.menu= menu
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(address)
        parcel.writeString(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Restaurant> {
        override fun createFromParcel(parcel: Parcel): Restaurant {
            return Restaurant(parcel)
        }

        override fun newArray(size: Int): Array<Restaurant?> {
            return arrayOfNulls(size)
        }
    }
}

private val tour_director_key: String? = null
private val last_name: String? = null
private val location_latitude: String? = null
private val tour_id: String? = null
private val photo: String? = null
private val tour_director_name: String? = null
private val middle_name: String? = null
private val location_longitude: String? = null
private val passenger_id: String? = null
private const val location_updated: Long = 0
private val tour_director: String? = null
private val email: String? = null
private val first_name: String? = null
private val mobile_phone: String? = null
private val td_id: String? = null


