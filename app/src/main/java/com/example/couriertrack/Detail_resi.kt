package com.example.couriertrack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.couriertrack.Fragment.Adapter.Historyadapter
import com.example.couriertrack.Model.Track
import com.example.couriertrack.Model.builder.Constant
import com.example.couriertrack.Repo.api.Mainrepo
import com.example.couriertrack.Viewmodel.api.Viewmodelapi
import com.example.couriertrack.Viewmodel.api.Vmfactory
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_resi)

        //api search
        val repository = Mainrepo()
        val vmoddelfactory = Vmfactory(repository)
        viewmodelresi = ViewModelProvider(this,vmoddelfactory).get(Viewmodelapi::class.java)

        //history
        adapter = Historyadapter()
        val recview = recyclerhistory
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(this)


        datalist = arrayListOf()
        val cari = intent.getStringExtra("resicari")
        findresi(cari!!)
    }

    private fun findresi(cari : String) {
        val apikey = Constant.api_key

        viewmodelresi.postsummary(apikey, "jne", cari)
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
}