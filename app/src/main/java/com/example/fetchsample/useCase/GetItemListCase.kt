package com.example.fetchsample.useCase

import com.example.fetchsample.model.domain.Item
import com.example.fetchsample.rest.ItemClient
import com.example.fetchsample.rest.ItemRepository
import com.example.fetchsample.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetItemListCase @Inject constructor (
    private val repository: ItemRepository
){

    operator fun invoke():  Flow<ResultState<List<Item>>> = repository.getItemList()
}