package com.example.apicoroutines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apicoroutines.databinding.ListRowBinding

class Adapter(private var userList: ArrayList<QuoteList.Result>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder( var binding: ListRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ListRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = userList.get(position)
    }

    override fun getItemCount(): Int {
    return  userList.size  }


}



