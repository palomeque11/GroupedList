package com.example.fetchsample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchsample.databinding.ItemLayoutBinding
import com.example.fetchsample.model.ItemList

class ItemAdapter(
    private val dataSet: List<ItemList>
) : RecyclerView.Adapter<ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.onBind(dataSet,position)
    }
    override fun getItemCount(): Int = dataSet.distinctBy { item -> item.listId }.size



}