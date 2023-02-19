package com.example.e_hotelsapplication.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Menu(
    val fimage: String?=null,
    val foodname: String? =null,
    val price: String?= null
):Parcelable

