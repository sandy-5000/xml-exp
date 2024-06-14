package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.data.ItemDetails


class Tab2 : Fragment() {


    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab2, container, false)
        recyclerView = view.findViewById(R.id.recyclerview_horizontal)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = AdapterClass(generateData())
        return view
    }
    private fun generateData():ArrayList<ItemDetails>{
        val items = arrayListOf(
            ItemDetails("asas", "sadas", "35811343"),
            ItemDetails("John Doe", "123 Main St", "5551234567"),
            ItemDetails("Jane Smith", "456 Oak Ave", "5559876543"),
            ItemDetails("Alice Johnson", "789 Pine Rd", "5557654321"),
            ItemDetails("Bob Brown", "101 Maple Blvd", "5556781234")
        )
        return items
    }


}