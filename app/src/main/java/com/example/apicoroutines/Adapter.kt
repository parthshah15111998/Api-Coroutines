package com.example.apicoroutines

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val userList: ArrayList<QuoteList.Result>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun getItems(user:QuoteList.Result) {
            itemView.findViewById<TextView>(R.id.tv_name)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoyt=LayoutInflater.from(parent.context).inflate(R.layout.list_row,parent,false)
        return ViewHolder(layoyt)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.getItems(userList[position])
    }

    override fun getItemCount(): Int {
    return  userList.size  }


}



