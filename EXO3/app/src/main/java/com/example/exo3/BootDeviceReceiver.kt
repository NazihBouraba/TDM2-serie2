package com.example.exo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootDeviceReceiver: BroadcastReceiver() {
    private val TAG_BOOT_BROADCAST_RECEIVER = "BOOT_BROADCAST_RECEIVER"
    override fun onReceive(context: Context?, intent: Intent?) {

        val action = intent!!.action
        if(Intent.ACTION_BOOT_COMPLETED.equals(action))
        {
            val intent =  Intent(context, AdhanService::class.java)
            if (context != null) {
                context.startService(intent)
            }
        }
    }
}