package com.example.fetchsample.views.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.fetchsample.databinding.ItemTimeLayoutBinding
import com.example.fetchsample.model.domain.Item


class DetailHolder (private val binding: ItemTimeLayoutBinding): RecyclerView.ViewHolder(binding.root){
    fun onBind(item: Item) {
        binding.tvItem.text = "id:${item.id}  name:${item.name}"
    }

}
