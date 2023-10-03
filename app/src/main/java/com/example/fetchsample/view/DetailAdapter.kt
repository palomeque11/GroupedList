package com.example.fetchsample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchsample.databinding.ItemTimeLayoutBinding
import com.example.fetchsample.model.ItemList


class DetailAdapter(private val dataSet: List<ItemList>, private val pos:Int) : RecyclerView.Adapter<DetailHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailHolder(ItemTimeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: DetailHolder, position: Int) {
        holder.onBind(dataSet[position])
    }
    override fun getItemCount(): Int = dataSet.size

}