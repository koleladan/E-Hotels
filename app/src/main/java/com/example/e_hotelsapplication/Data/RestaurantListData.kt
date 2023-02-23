package com.example.e_hotelsapplication.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantListData(
    val restaurants: Map<String,Restaurant>? = null

):Parcelable


