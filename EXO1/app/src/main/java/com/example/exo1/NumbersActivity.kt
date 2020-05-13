package com.example.exo1

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class NumbersActivity : AppCompatActivity() , MediaPlayer.OnCompletionListener {

     var mMediaPlayer: MediaPlayer? = null

     var mAudioManager: AudioManager? = null






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)
        mAudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        val words = ArrayList<Word>()
        words.add(Word("one", "lutti", R.drawable.number_one, R.raw.number_one))
        words.add(Word("two", "otiiko", R.drawable.number_two, R.raw.number_two))
        words.add(Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three))
        words.add(Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four))
        words.add(Word("five", "massokka", R.drawable.number_five, R.raw.number_five))
        words.add(Word("six", "temmokka", R.drawable.number_six, R.raw.number_six))
        words.add(Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven))
        words.add(Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight))
        words.add(Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine))
        words.add(Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten))

        val adapter = WordAdapter(this,R.layout.list_item, words, R.color.category_numbers)

        val listView = findViewById(R.id.list) as ListView

        listView.adapter = adapter



        listView.setOnItemClickListener(OnItemClickListener { adapterView, view, postion, l ->
            val word = words[postion]
            mMediaPlayer?.release()
            mMediaPlayer = MediaPlayer.create(this@NumbersActivity, word.mAudioResourceId)
            mMediaPlayer!!.start()
            mMediaPlayer!!.setOnCompletionListener({ mMediaPlayer?.release()})
        })

    }

    override fun onStop() {
        super.onStop()
        mMediaPlayer?.release()
    }

    override fun onCompletion(mp: MediaPlayer?) {
        mMediaPlayer?.release()
    }

}
