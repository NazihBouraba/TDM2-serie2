package com.example.exo1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        numbers.setOnClickListener(
            View.OnClickListener
            {
                val numbersIntent = Intent(this@MainActivity, NumbersActivity::class.java)
                startActivity(numbersIntent)
            })

        video.setOnClickListener(
            View.OnClickListener
            {
                val videoIntent = Intent(this@MainActivity, VideoActivity::class.java)
                startActivity(videoIntent)
            })

    }
}
