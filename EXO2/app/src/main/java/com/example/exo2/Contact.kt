package com.example.exo2

import java.io.Serializable

class Contact (nom:String , mail:String , numero : String) : Serializable {
    var nom : String = nom
    var mail : String = mail
    var numero : String = numero
}