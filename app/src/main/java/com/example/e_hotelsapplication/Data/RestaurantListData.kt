package com.example.e_hotelsapplication.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantListData(
     val menu:Menu? = null,
    val name:String? = null,
    val address:String? =null,
    val image:String?= null,
     val hours:Hours? =null
):Parcelable


