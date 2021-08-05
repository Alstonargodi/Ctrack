package com.example.couriertrack.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.couriertrack.API.History
import com.example.couriertrack.R
import com.example.couriertrack.room.Find
import kotlinx.android.synthetic.main.card_history.view.*
import org.w3c.dom.Text

class Historyadapter:RecyclerView.Adapter<Historyadapter.viewHolder> () {
    private var data = emptyList<History>()

    class viewHolder(item : View): RecyclerView.ViewHolder(item) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Historyadapter.viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_history,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: Historyadapter.viewHolder, position: Int) {
        var curitem = data[position]
        holder.itemView.TV_DATE.text = curitem.date.toString()
        holder.itemView.TV_DESC.text = curitem.desc.toString()
        holder.itemView.TV_LOCATION.text = curitem.location.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    //set data kedalam adapter
    fun setdata(find : List<History>){
        data = find
        notifyDataSetChanged()
    }
}