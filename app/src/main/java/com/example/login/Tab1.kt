package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.data.ItemDetails

class Tab1 : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemDetails: ArrayList<ItemDetails>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tab1, container, false)
        recyclerView = view.findViewById(R.id.recyclerview_vertical)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AdapterClass(generateData())
        return view
    }

    private fun generateData():ArrayList<ItemDetails>{
        val result = arrayListOf<ItemDetails>()
        result.add(ItemDetails("alpha", "south street", "6382628267"))
        result.add(ItemDetails("beta", "north street", "8698212342"))
        result.add(ItemDetails("gamma", "east street", "1353437652"))
        result.add(ItemDetails("sarfa", "west street", "13452345252"))
        return result
    }


}