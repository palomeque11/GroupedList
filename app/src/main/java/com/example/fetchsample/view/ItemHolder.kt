package com.example.fetchsample.view

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchsample.databinding.ItemLayoutBinding
import com.example.fetchsample.model.ItemList

class ItemHolder (private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(itemlist: List<ItemList>, position:Int){
        val listId = position +1
       val filterList = itemlist.filter { item -> item.listId == listId && !item.name.isNullOrBlank() }
           .sortedWith(compareBy({ it.name.length }, { it.name }))
        binding.hourResults.layoutManager = LinearLayoutManager(binding.root.context)
        binding.hourResults.adapter = DetailAdapter(filterList,position)
        binding.hourResults.visibility = View.GONE
        binding.consLayout.setOnClickListener {
            binding.hourResults.visibility =
                if( binding.hourResults.visibility == View.VISIBLE){
                    View.GONE
                }else{
                    View.VISIBLE
                }
        }
        binding.tvDay.text = "ListId $listId"
    }
}