package com.example.e_hotelsapplication.Data


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class  User(
    val fname:String?=null,
    val lname:String?=null,
    val email:String?=null,
    val pin:String?=null,
    val confirm:String?=null) : Parcelable
