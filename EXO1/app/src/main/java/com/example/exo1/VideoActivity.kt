package com.example.exo1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {

    private var mc: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        btn.setOnClickListener { lireVideo(R.raw.fortnite) }
    }

    private fun lireVideo(resId: Int) {
        val vv = findViewById<VideoView>(R.id.videoPlayer)
        if (mc == null) {

            mc = MediaController(this)
            vv.setMediaController(mc)
            val video = Uri.parse("android.resource://" + this?.packageName + "/"
                    + resId) //do not add any extension
            vv.setVideoURI(video)

            vv.start()

        } else {
            if (!vv.isPlaying) {
                vv.start()

            } else {
                vv.pause()
            }
        }
    }
}
