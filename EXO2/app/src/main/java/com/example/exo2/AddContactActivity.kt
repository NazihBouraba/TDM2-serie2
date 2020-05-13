package com.example.exo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_contact.*
import java.io.File

class AddContactActivity : AppCompatActivity() {

    var lis_contact = ArrayList<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        lis_contact = FileHelper.lirefichier(this)
        ajouter.setOnClickListener({

            var c = Contact(nom_et.text.toString(),numero_et.text.toString(),mail_et.text.toString())
            lis_contact.add(c)
            FileHelper.writetofile(this,lis_contact)
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        })
    }
}
