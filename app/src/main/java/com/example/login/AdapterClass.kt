package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.data.RecyclerDetails

class AdapterClass(private val recyclerDetails: List<RecyclerDetails>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {
    class ViewHolderClass(itemView: View):RecyclerView.ViewHolder(itemView){
        val field1 = itemView.findViewById<ImageView>(R.id.image1)
        val field2 = itemView.findViewById<ImageView>(R.id.image2)
        val field3 = itemView.findViewById<TextView>(R.id.text1)
        val field4 = itemView.findViewById<TextView>(R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return recyclerDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = recyclerDetails[position]
        holder.field1.setImageResource(currentItem.image1)
        holder.field2.setImageResource(currentItem.image2)
        holder.field3.text = currentItem.text1
        holder.field4.text = currentItem.text2
    }

}