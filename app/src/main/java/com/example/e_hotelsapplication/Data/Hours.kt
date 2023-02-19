package com.example.e_hotelsapplication.Data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hours(
    val Monday:String?= null,
    val Tuesday:String? = null,
    val Wednesday:String? = null,
    val Thursday:String?= null,
    val Friday:String?=null,
    val Saturday:String?= null,
    val Sunday:String?= null
):Parcelable
