package com.bhushan.chatapplication
// it is used to store user data
class User {
    var name: String? = null
    var email: String? = null
    var uid: String? = null

    constructor(){

    }
    constructor(name: String?, email: String?, uid: String?){
        this.name = name
        this.email = email
        this.uid = uid
    }


}