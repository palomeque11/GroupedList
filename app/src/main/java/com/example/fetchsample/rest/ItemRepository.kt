package com.example.fetchsample.rest

import com.example.fetchsample.model.domain.Item
import com.example.fetchsample.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getItemList(): Flow<ResultState<List<Item>>>
}