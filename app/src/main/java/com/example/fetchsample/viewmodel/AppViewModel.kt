package com.example.fetchsample.viewmodel

import androidx.lifecycle.ViewModel
import com.example.fetchsample.model.ItemApi
import com.example.fetchsample.model.ItemList
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(retrofit: Retrofit) : ViewModel() {

    private val api: ItemApi by lazy {
        retrofit.create(ItemApi::class.java)
    }


    fun getItemList(): Call<List<ItemList>> {
         return api.getItemList()
    }
}

