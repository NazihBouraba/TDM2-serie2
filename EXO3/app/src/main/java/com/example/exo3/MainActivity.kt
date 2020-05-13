package com.example.exo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private val ACTION_SERVICE = "dz.esi.demonotifsser"
    companion object{
        val context =this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val i = Intent()

        i.setClass(this, BootDeviceReceiver::class.java)
        sendBroadcast(i)

        val intent = Intent(this, AdhanService::class.java)
        intent.action = ACTION_SERVICE
        startService(intent)
    }
}
