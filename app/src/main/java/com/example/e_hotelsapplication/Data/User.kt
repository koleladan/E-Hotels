package com.example.e_hotelsapplication.Data

class User {
    var lname:String?=null
    var fname:String?=null
    var email:String?=null
    var pin:String?=null
    var confirm:String?=null

    constructor(){}


    constructor(lname:String?, fname:String?, email:String?, pin:String?, confirm:String?){
        this.lname =lname
        this.fname = fname
        this.email= email
        this.pin = pin
        this.confirm = confirm
    }



}