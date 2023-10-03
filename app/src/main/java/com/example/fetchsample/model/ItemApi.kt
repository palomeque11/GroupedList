package com.example.fetchsample.model


import retrofit2.Call
import retrofit2.http.GET

interface ItemApi {

    @GET(END_POINT)
    fun getItemList(): Call<List<ItemList>>
}