package com.example.couriertrack.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.couriertrack.Detail_resi
import com.example.couriertrack.Fragment.Adapter.Resiadapter
import com.example.couriertrack.Fragment.util.swipedelete
import com.example.couriertrack.Model.room.entity.Resi
import com.example.couriertrack.R
import com.example.couriertrack.Repo.api.Mainrepo
import com.example.couriertrack.Viewmodel.api.Viewmodelapi
import com.example.couriertrack.Viewmodel.api.Vmfactory
import com.example.couriertrack.Viewmodel.room.resiviewmodel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class Home : Fragment() {
    lateinit var vmodel : Viewmodelapi
    lateinit var vresimodel : resiviewmodel




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //recyclerview
        val adapter = Resiadapter()
        val recview = view.rv_history
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())
        vresimodel = ViewModelProvider(this).get(resiviewmodel::class.java)
        vresimodel.readresi.observe(viewLifecycleOwner, Observer { response->
            adapter.setdata(response)
        })



        view.spinn_service.onItemSelectedListener = object : AdapterView.OnItemSelectedListener , AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item = parent?.getItemAtPosition(position)

                when(item){
                    "jne"->{
                        findresi("jne")
                    }
                    "sicepat"->{
                        findresi("sicepat")
                    }
                    "wahana"->{
                        findresi("wahana")
                    }
                    "tiki"->{
                        findresi("tiki")
                    }
                    "anteraja"->{
                        findresi("anteraja")
                    }
                    "jnt"->{
                        findresi("jnt")
                    }
                    "ninja"->{
                        findresi("ninja")
                    }
                    "lion"->{
                        findresi("lion")
                    }
                    "pcp express"->{
                        findresi("pcpexpress")
                    }
                    "jet express"->{
                        findresi("jetexpress")
                    }
                    "rex express"->{
                        findresi("rexexpress")
                    }
                    "first logistic"->{
                        findresi("firstlogistic")
                    }
                    "id express"->{
                        findresi("idexpress")
                    }
                    "shopee express"->{
                        findresi("shopeeexpress")
                    }
                    "kgx express"->{
                        findresi("kgxexpress")
                    }
                    "sap express"->{
                        findresi("sapexpress")
                    }
                    "jx express"->{
                        findresi("jxexpress")
                    }
                    "rpx"->{
                        findresi("rpx")
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                findresi("jne")
            }
        }


        return view
    }

    private fun findresi(kurir : String){
        //api search
        val repository = Mainrepo()
        val vmoddelfactory = Vmfactory(repository)
        vmodel = ViewModelProvider(this,vmoddelfactory).get(Viewmodelapi::class.java)

        btn_find.setOnClickListener {
            val find = ET_NORESI.text

                if (find.isNotEmpty()){
                    val intent = Intent(context,Detail_resi::class.java)
                    intent.putExtra("resicari",find.toString())
                    intent.putExtra("resikurir",kurir.toString())
                    startActivity(intent)
                }else{
                    Toast.makeText(context,"Please fill out",Toast.LENGTH_SHORT).show()
                }
        }


    }


}