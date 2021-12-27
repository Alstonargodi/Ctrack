package com.example.couriertrack.Fragment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.couriertrack.Model.room.entity.Resi
import com.example.couriertrack.R
import kotlinx.android.synthetic.main.card_findhis.view.*

class Resiadapter:RecyclerView.Adapter<Resiadapter.viewholder>() {
    class viewholder(itemview : View): RecyclerView.ViewHolder(itemview) {}
    private var dataresi = emptyList<Resi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Resiadapter.viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_findhis,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: Resiadapter.viewholder, position: Int) {
       var curitem = dataresi[position]
        holder.itemView.CV_AWB.text = curitem.resi.toString()
        holder.itemView.tvhome_kurir.text = curitem.kurir.toString()
    }


    override fun getItemCount(): Int {
        return dataresi.size
    }

    fun setdata(data : List<Resi>){
        dataresi = data
        notifyDataSetChanged()
    }

}