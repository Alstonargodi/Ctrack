package com.example.couriertrack

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.couriertrack.Model.Spinner.Spinasal_prov
import com.example.couriertrack.Model.builder.Constant
import com.example.couriertrack.Repo.api.Mainrepo
import com.example.couriertrack.Viewmodel.api.Viewmodelapi
import com.example.couriertrack.Viewmodel.api.Vmfactory
import com.example.couriertrack.Viewmodel.room.resiviewmodel
import kotlinx.android.synthetic.main.fragment_cekongkit.view.*


class Cekongkit : Fragment() {

    lateinit var apivmodel : Viewmodelapi

    var spinasalProv = ArrayList<String>()
    var spinasalkota = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cekongkit, container, false)
        val repo = Mainrepo()
        val vmodelfactory = Vmfactory(repo)
        apivmodel = ViewModelProvider(this,vmodelfactory).get(Viewmodelapi::class.java)

        spinasalProv = arrayListOf()

        val key = Constant.oApi_key
        apivmodel.getkota(key)
        apivmodel.listkotaresponse.observe(viewLifecycleOwner, Observer { response->
            if (response.isSuccessful){
                var datakota = response.body()?.rajaongkir?.results

                for (i in datakota!!.indices){
                    spinasalProv.add(datakota[i].province)
                    val array  = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, spinasalProv)
                    array.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                    view.spinongkir_asal_prov.adapter = array
                    view.spinongkir_asal_prov2.adapter = array

                    spinasalkota.add(datakota[i].cityName)
                    val citarra = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,spinasalkota)
                    citarra.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                    view.spinongkir_asal_kota.adapter = citarra
                    view.spinongkir_asal_kota2.adapter = citarra


                }
            }else{
                Log.d("response cari kota","resnposen gagal")
            }
        })


        return view
    }
}