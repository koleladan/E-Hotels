package com.example.e_hotelsapplication.Data

class Menu{
    var fimage:String? = null
    var foodname:String? = null
    var price:String? = null

    constructor(){}

    constructor(
        fimage:String?,
        foodname:String?,
        price:String?
    ){
        this.foodname = foodname
        this.fimage = fimage
        this.price = price
    }
}