package com.example.e_hotelsapplication.Data

 class RestaurantListData{
    var name:String? = null
    var address:String? =null
    var image:String?= null
     var hours:Hours? =null
    constructor(){}

    constructor(
        name:String?,
        address:String?,
        image:String?,
        hours: Hours?

    ){
        this.name = name
        this.address = address
        this.image = image
        this.hours =hours
    }
}

