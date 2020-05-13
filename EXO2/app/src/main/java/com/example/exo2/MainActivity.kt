package com.example.exo2

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {

    val CUSTOM_INTENT = "dz.esi.demobroadcast"
    private val appPermission = arrayOf(Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_MMS)

    var liste_contact = ArrayList<Contact>()
    override fun onPause() {
        super.onPause()
        FileHelper.writetofile(this,liste_contact)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val i = Intent()
        i.action = CUSTOM_INTENT
        i.setClass(this, SmsReceiver::class.java)
        this.sendBroadcast(i)

         liste_contact = FileHelper.lirefichier(this)
        var contactadapter = ContactAdapter(liste_contact,this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = contactadapter
        recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        addcontactbtn.setOnClickListener({

            var intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)

        })
    }

    override fun onStop() {
        super.onStop()
        FileHelper.writetofile(this,liste_contact)
    }



}
