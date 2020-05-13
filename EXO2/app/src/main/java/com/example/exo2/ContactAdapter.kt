package com.example.exo2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactAdapter (ls : ArrayList<Contact> , cont : Context  ) : RecyclerView.Adapter<ViewHolder>()  {

    var contatc_list = ls
    var context = cont
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val ite = layoutInflater.inflate(R.layout.contact_item, parent, false)
        return ViewHolder(ite)
    }

    override fun getItemCount(): Int {
        return  contatc_list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.nom_txt.text = contatc_list[position].nom
        holder.itemView.numero_txt.text = contatc_list[position].numero
        holder.itemView.mail_txt.text = contatc_list[position].mail

        holder.itemView.setOnClickListener({

            if(position!=0){  contatc_list.removeAt(position)
                notifyItemRemoved(position)
               FileHelper.writetofile(context , contatc_list)
            }
            else{
                contatc_list.clear()
                notifyDataSetChanged()
                FileHelper.writetofile(context , contatc_list)
            }





        })



    }
}