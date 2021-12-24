package com.example.couriertrack.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.couriertrack.Fragment.Adapter.Historyadapter
import com.example.couriertrack.Model.room.entity.Find
import com.example.couriertrack.R
import com.example.couriertrack.Repo.api.Mainrepo
import com.example.couriertrack.Viewmodel.api.Viewmodelapi
import com.example.couriertrack.Viewmodel.api.Vmfactory
import com.example.couriertrack.Viewmodel.room.roomviewmodel
import kotlinx.android.synthetic.main.fragment_detailresi.*
import kotlinx.android.synthetic.main.fragment_detailresi.view.*

class Detailresi: Fragment() {
    lateinit var vmodelresi : Viewmodelapi
    lateinit var mroomvmodel : roomviewmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detailresi, container, false)

        //api search
        val repository = Mainrepo()
        val vmoddelfactory = Vmfactory(repository)
        vmodelresi = ViewModelProvider(this,vmoddelfactory).get(Viewmodelapi::class.java)

        findresi()

        //history
        val adapter = Historyadapter()
        val recview = view.recyclerhistory
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())
        mroomvmodel = ViewModelProvider(this).get(roomviewmodel::class.java)
        getHistory()
        setHistory()
        mroomvmodel.readhistory.observe(viewLifecycleOwner, Observer { response ->
            adapter.setdata(response)
        })

        return view
    }

    //Mencari data resi
    private fun findresi(){
        val cari = arguments?.getLong("awb")

        vmodelresi.postsummary("jne",cari!!)
        vmodelresi.summaryrespons.observe(viewLifecycleOwner, Observer { response ->
            tv_resi.setText(response.body()?.data?.summary?.awb.toString())
            tv_status.setText(response.body()?.data?.summary?.status.toString())
            tv_time.setText(response.body()?.data?.summary?.date.toString())
            tv_service.setText(response.body()?.data?.summary?.service.toString())
            tv_courier.setText(response.body()?.data?.summary?.courier.toString())
            tv_weight.setText(response.body()?.data?.summary?.weight.toString())
            tv_shipper.setText(response.body()?.data?.detail?.shipper.toString())
            tv_origin.setText(response.body()?.data?.detail?.origin.toString())
            tv_destinatnion.setText(response.body()?.data?.detail?.destination.toString())
            tv_receiver.setText(response.body()?.data?.detail?.receiver.toString())
        })
    }


    private fun getHistory(){
        vmodelresi.historyresponse.observe(viewLifecycleOwner, Observer { response ->
            val input = Find(0,
                response.body()?.data?.history?.get(0)?.date.toString(),
                response.body()?.data?.history?.get(0)?.desc.toString(),
                response.body()?.data?.history?.get(0)?.location.toString(),
            )
            mroomvmodel.addhistory(input)
        })
    }

    private fun setHistory(){
        val adapter = Historyadapter()
        val recview = view?.recyclerhistory
        if (recview != null) {
            recview.adapter = adapter
        }
        if (recview != null) {
            recview.layoutManager = LinearLayoutManager(requireContext())
        }
        mroomvmodel.readhistory.observe(viewLifecycleOwner, Observer { response ->
            adapter.setdata(response)
        })
    }

}