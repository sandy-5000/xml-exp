package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.data.ItemDetails

class AdapterClass(private val itemDetails: List<ItemDetails>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    class ViewHolderClass(itemView:View):RecyclerView.ViewHolder(itemView){
        val field1 = itemView.findViewById<TextView>(R.id.field1)
        val field2 = itemView.findViewById<TextView>(R.id.field2)
        val field3 = itemView.findViewById<TextView>(R.id.field3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolderClass(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = itemDetails[position]
        holder.field1.text = currentItem.name
        holder.field2.text = currentItem.address
        holder.field3.text = currentItem.mobile
    }

    override fun getItemCount(): Int {
        return itemDetails.size
    }

}