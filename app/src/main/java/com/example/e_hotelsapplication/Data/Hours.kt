package com.example.e_hotelsapplication.Data

class Hours{
    var Monday:String?= null
    var Tuesday:String? = null
    var Wednesday:String? = null
    var Thursday:String?= null
    var Friday:String?=null
    var Saturday:String?= null
    var Sunday:String?= null
    constructor(){}

    constructor(
        Monday:String?,
        Tuesday:String?,
        Wednesday:String?,
        Thursday:String?,
        Friday:String?,
        Saturday:String?,
        Sunday:String?

    ){
        this.Sunday = Sunday
        this.Friday =Friday
        this.Monday =Monday
        this.Saturday =Saturday
        this.Tuesday =Tuesday
        this.Wednesday = Wednesday
        this.Thursday = Thursday
    }



}
