package com.example.couriertrack.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.couriertrack.Adapter.findadapter
import com.example.couriertrack.R
import com.example.couriertrack.Repo.Mainrepo
import com.example.couriertrack.Viewmodel.Viewmodelapi
import com.example.couriertrack.Viewmodel.Vmfactory
import com.example.couriertrack.Viewmodel.roomviewmodel
import com.example.couriertrack.databinding.FragmentHomeBinding
import com.example.couriertrack.room.Find
import kotlinx.android.synthetic.main.activity_detailresi.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    lateinit var vmodel : Viewmodelapi
    lateinit var rmodel : roomviewmodel

    lateinit var mbinding : FragmentHomeBinding
    private val apikey : String = "f5e7c7af783bdceb07717f5622790901afd733615a781b591cf109ef276e551b"
    private val kurir : String = "jne"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val intent = Intent(context, Activity_detailresi::class.java)


        //recyclerview
        val adapter = findadapter()
        val recview = view.rv_history
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())
        rmodel = ViewModelProvider(this).get(roomviewmodel::class.java)
        rmodel.readhistory.observe(viewLifecycleOwner, Observer { find->
            adapter.setdata(find)
        })


        //api search
        val repository = Mainrepo()
        val vmoddelfactory = Vmfactory(repository)
        vmodel = ViewModelProvider(this,vmoddelfactory).get(Viewmodelapi::class.java)
        view.btn_find.setOnClickListener {
                val cari = ET_NORESI.text.toString().toLong()
                Toast.makeText(context,"Finding ${cari}",Toast.LENGTH_LONG).show()
                addhistory()

                // awb summary
                vmodel.postsummary(apikey,kurir,cari)
                vmodel.summaryrespons.observe(viewLifecycleOwner, Observer { response ->
                    if(response.isSuccessful){

                        val status = response.body()?.status.toString()
                        val date = response.body()?.date.toString()
                        val berat = response.body()?.weight.toString()
                        val service = response.body()?.service.toString()

                        intent.putExtra("resi",cari)
                        intent.putExtra("status",status)
                        intent.putExtra("date",date)
                        intent.putExtra("berat",berat)
                        intent.putExtra("service",service)
                        startActivity(intent)
                    }else{
                        Toast.makeText(context,"Can't find ${cari}",Toast.LENGTH_LONG).show()
                    }
                })

                //awb history
                vmodel.posthistory(apikey,kurir,cari)
                vmodel.historyrespons.observe(viewLifecycleOwner, Observer { res ->
                    if(res.isSuccessful){
                        val date = res.body()?.date
                        val desc = res.body()?.desc.toString()
                        val location = res.body()?.location.toString()

                        intent.putExtra("date",date)
                        intent.putExtra("desc",desc)
                        intent.putExtra("location",location)
                        startActivity(intent)
                    }else{
                        Toast.makeText(context,"Can't find ${cari}",Toast.LENGTH_LONG).show()
                    }
                })
        }
        return view
    }

    private fun addhistory(){
        val resi = ET_NORESI.text

       lifecycleScope.launch {
           val resi = Find(0,Integer.parseInt(resi.toString()))
            rmodel.addhistory(resi)

           Toast.makeText(context,"adding ${resi}",Toast.LENGTH_LONG).show()
       }
    }

    private fun deletehistory(){

    }
}