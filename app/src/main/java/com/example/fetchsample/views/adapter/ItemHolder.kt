package com.example.fetchsample.views.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchsample.databinding.ItemLayoutBinding
import com.example.fetchsample.model.domain.Item
import com.example.fetchsample.model.domain.getUniqueGroupId
import com.example.fetchsample.model.domain.splitByGroupId

class ItemHolder (private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(itemlist: List<Item>,listId:Int, position:Int){
       val filterList = itemlist.splitByGroupId(listId)
        binding.itemResult.apply {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = DetailAdapter(filterList,position)
            visibility = View.GONE
            binding.consLayout.setOnClickListener {
                this.visibility =
                    if( this.visibility == View.VISIBLE){
                        View.GONE
                    }else{
                        View.VISIBLE
                    }
            }
        }

        binding.tvTitleCard.text = "ListId $listId"
    }
}