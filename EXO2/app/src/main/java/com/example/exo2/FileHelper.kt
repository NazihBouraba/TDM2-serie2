package com.example.exo2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object FileHelper {

    fun lirefichier(contect : Context) : ArrayList<Contact>{
        val fileName = "contact.txt"
        val fis: FileInputStream = contect.openFileInput(fileName)
        var iss = ObjectInputStream(fis)
        val interventions: ArrayList<Contact> = iss.readObject() as ArrayList<Contact>
        iss.close()
        fis.close()

        return interventions
    }


    fun writetofile(contect : Context,liste_contact:ArrayList<Contact>){



        val fileName = "contact.txt"
        val fos: FileOutputStream = contect.openFileOutput(fileName, AppCompatActivity.MODE_PRIVATE)
        val os = ObjectOutputStream(fos)
        os.writeObject(liste_contact)
        os.close()
        fos.close()


    }


}