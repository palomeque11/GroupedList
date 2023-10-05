package com.example.fetchsample.rest


import com.example.fetchsample.utils.END_POINT
import com.example.fetchsample.model.domain.Item
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ItemClient {

    @GET(END_POINT)
    fun getItemList(): Call<List<Item>>
}