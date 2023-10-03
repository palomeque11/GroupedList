package com.example.fetchsample.view

import androidx.recyclerview.widget.RecyclerView
import com.example.fetchsample.databinding.ItemTimeLayoutBinding
import com.example.fetchsample.model.ItemList


class DetailHolder (private val binding: ItemTimeLayoutBinding): RecyclerView.ViewHolder(binding.root){
    fun onBind(hourItem: ItemList) {
        binding.tvDay.text = "id:${hourItem.id}  name:${hourItem.name}"
    }

}
