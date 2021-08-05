package com.example.couriertrack.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.couriertrack.R
import com.example.couriertrack.room.Find
import kotlinx.android.synthetic.main.card_findhis.view.*

class findadapter: RecyclerView.Adapter<findadapter.viewHolder>() {
    private var data = emptyList<Find>()

    class viewHolder(itemview : View): RecyclerView.ViewHolder(itemview) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): findadapter.viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_findhis,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: findadapter.viewHolder, position: Int) {
        val item = data[position]
        holder.itemView.CV_AWB.text = item.number.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setdata(find : List<Find>){
        data = find
        notifyDataSetChanged()
    }

}