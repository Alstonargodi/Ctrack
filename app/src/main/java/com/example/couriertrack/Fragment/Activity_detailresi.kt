package com.example.couriertrack.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.couriertrack.databinding.ActivityDetailresiBinding

class Activity_detailresi : AppCompatActivity() {
 lateinit var mbinding : ActivityDetailresiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityDetailresiBinding.inflate(layoutInflater)
        setContentView(mbinding.root)
        val intent = intent
        //summary
        val status = intent.getStringExtra("status")
        val resi = intent.getStringExtra("resi")
        val date = intent.getStringExtra("date")
        val berat = intent.getStringExtra("berat")
        val service = intent.getStringExtra("service")
        mbinding.tvResi.text = resi.toString()
        mbinding.tvStatus.text = status.toString()
        mbinding.tvDate.text = date.toString()
        mbinding.tvWeight.text = berat.toString()
        mbinding.tvService.text = berat.toString()

        //todo room


    }
}