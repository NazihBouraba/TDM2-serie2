package com.example.exo1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class WordAdapter(private val _ctx: Context, rId: Int, private val words: MutableList<Word>,colorResourceId : Int) : ArrayAdapter<Word>(_ctx, rId, words) {



    var mColorResourceId = colorResourceId
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Check if the existing view is being reused, otherwise inflate the view


        // Check if the existing view is being reused, otherwise inflate the view
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                R.layout.list_item, parent, false
            )
        }


        val currentWord = getItem(position)

        val miwokTextView =
            listItemView!!.findViewById<View>(R.id.miwok_text_view) as TextView
        miwokTextView.setText(currentWord?.mMiwokTranslation)

        val defaultTextView =
            listItemView!!.findViewById<View>(R.id.default_text_view) as TextView

        if (currentWord != null) {
            defaultTextView.setText(currentWord.mDefaultTranslation)
        }

        val imageView =
            listItemView!!.findViewById<View>(R.id.icon_image_view) as ImageView

        if (currentWord!= null) {
            imageView.setImageResource(currentWord.NO_IMAGE_PROVIDED)
            imageView.visibility = View.VISIBLE
        } else {
            imageView.visibility = View.GONE
        }

        val textContainer =
            listItemView!!.findViewById<View>(R.id.text_container)

        val color: Int = ContextCompat.getColor(context, mColorResourceId)

        textContainer.setBackgroundColor(color)


        return listItemView!!
    }
}