package com.example.e_hotelsapplication.Data

 class RestaurantListData{
    var name:String? = null
    var address:String? =null
    var image:String?= null
    constructor(){}

    constructor(
        name:String?,
        address:String?,
        image:String?
    ){
        this.name = name
        this.address = address
        this.image = image
    }
}
