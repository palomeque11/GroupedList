package com.example.fetchsample.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchsample.databinding.ItemTimeLayoutBinding
import com.example.fetchsample.model.domain.Item


class DetailAdapter(private val dataSet: List<Item>, private val pos:Int) : RecyclerView.Adapter<DetailHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailHolder(ItemTimeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: DetailHolder, position: Int) {
        holder.onBind(dataSet[position])
    }
    override fun getItemCount(): Int = dataSet.size

}