package com.example.couriertrack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.couriertrack.Fragment.Adapter.Historyadapter
import com.example.couriertrack.Model.Track
import com.example.couriertrack.Model.builder.Constant
import com.example.couriertrack.Model.room.entity.Resi
import com.example.couriertrack.Repo.api.Mainrepo
import com.example.couriertrack.Viewmodel.api.Viewmodelapi
import com.example.couriertrack.Viewmodel.api.Vmfactory
import com.example.couriertrack.Viewmodel.room.resiviewmodel
import com.example.couriertrack.databinding.ActivityDetailResiBinding
import kotlinx.android.synthetic.main.activity_detail_resi.*
import kotlinx.android.synthetic.main.activity_detail_resi.recyclerhistory
import kotlinx.android.synthetic.main.activity_detail_resi.tv_courier
import kotlinx.android.synthetic.main.activity_detail_resi.tv_destinatnion
import kotlinx.android.synthetic.main.activity_detail_resi.tv_origin
import kotlinx.android.synthetic.main.activity_detail_resi.tv_receiver
import kotlinx.android.synthetic.main.activity_detail_resi.tv_resi
import kotlinx.android.synthetic.main.activity_detail_resi.tv_service
import kotlinx.android.synthetic.main.activity_detail_resi.tv_shipper
import kotlinx.android.synthetic.main.activity_detail_resi.tv_status
import kotlinx.android.synthetic.main.activity_detail_resi.tv_weight


class Detail_resi : AppCompatActivity() {
    private var datalist = ArrayList<Track>()
    private var adapter = Historyadapter()

    lateinit var viewmodelresi : Viewmodelapi
    lateinit var resiroom : resiviewmodel

    lateinit var binding : ActivityDetailResiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailResiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //api search
        val repository = Mainrepo()
        val vmoddelfactory = Vmfactory(repository)
        viewmodelresi = ViewModelProvider(this,vmoddelfactory).get(Viewmodelapi::class.java)
        resiroom = ViewModelProvider(this).get(resiviewmodel::class.java)

        //history
        adapter = Historyadapter()
        val recview = binding.recyclerhistory
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(this)


        datalist = arrayListOf()
        val cari = intent.getStringExtra("resicari")
        val kurir = intent.getStringExtra("resikurir")
        findresi(kurir!!,cari!!)

        binding.btnfavResi.setOnClickListener {
            val resi = intent.getStringExtra("resicari")
            val kurir = intent.getStringExtra("resikurir")
            addresi(kurir!!,resi!!)

        }


    }

    private fun findresi(kurir : String,cari : String) {
        val apikey = Constant.api_key

        viewmodelresi.postsummary(apikey, kurir, cari)
        viewmodelresi.summaryrespons.observe(this, Observer { response ->
            tv_resi.setText(response.body()?.data?.summary?.awb.toString())
            tv_status.setText(response.body()?.data?.summary?.status.toString())
            tv_service.setText(response.body()?.data?.summary?.service.toString())
            tv_courier.setText(response.body()?.data?.summary?.courier.toString())
            tv_weight.setText(response.body()?.data?.summary?.weight.toString())
            tv_shipper.setText(response.body()?.data?.detail?.shipper.toString())
            tv_origin.setText(response.body()?.data?.detail?.origin.toString())
            tv_destinatnion.setText(response.body()?.data?.detail?.destination.toString())
            tv_receiver.setText(response.body()?.data?.detail?.receiver.toString())

            Log.d("route", response.body()?.data?.history.toString())
            val history = response.body()?.data?.history
            for (i in history!!.indices) {
                Log.d("historyindicie", history[i].date)
                val input = Track(
                    history[i].date.toString(),
                    history[i].location.toString(),
                    history[i].desc.toString(),
                )
                datalist.add(input)
                adapter.setdata(datalist)
            }
        })
    }


    private fun addresi(kurir: String,cari : String){
        val data = Resi(
            0,
            kurir,
            cari
        )

        Toast.makeText(this,"add to favorite",Toast.LENGTH_SHORT).show()
        resiroom.add(data)
    }
}