package com.example.couriertrack.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        //swipe recyclerview

        //api search
        val repository = Mainrepo()
        val vmoddelfactory = Vmfactory(repository)
        vmodel = ViewModelProvider(this,vmoddelfactory).get(Viewmodelapi::class.java)
        view.btn_find.setOnClickListener {
                val find = ET_NORESI.text
                val cari = 8825112045716759 //test
                if (find.isNotEmpty()){
                    val intent = Intent(context,Detail_resi::class.java)
                    intent.putExtra("resicari",find.toString())
                    startActivity(intent)
                }else{
                    Toast.makeText(context,"Please fill out",Toast.LENGTH_SHORT).show()
                }
        }

        return view
    }


}