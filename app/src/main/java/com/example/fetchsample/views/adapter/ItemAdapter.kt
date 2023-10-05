package com.example.fetchsample.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchsample.databinding.ItemLayoutBinding
import com.example.fetchsample.model.domain.Item
import com.example.fetchsample.model.domain.getUniqueGroupId

class ItemAdapter(
    private val dataSet: List<Item>,
) : RecyclerView.Adapter<ItemHolder>() {

    private lateinit var groupIds : List<Int>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemHolder {
        groupIds = dataSet.getUniqueGroupId()
        return ItemHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.onBind(dataSet,groupIds[position],position)
    }
    override fun getItemCount(): Int = dataSet.getUniqueGroupId().size



}