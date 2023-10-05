package com.example.fetchsample.model

import com.example.fetchsample.model.domain.Item
import com.example.fetchsample.rest.ItemClient
import com.example.fetchsample.rest.ItemRepository
import com.example.fetchsample.utils.ResultState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemClient: ItemClient,
    private val ioDispatcher: CoroutineDispatcher
):ItemRepository {

    override fun getItemList(): Flow<ResultState<List<Item>>> = flow {
        emit(ResultState.Loading)

        try {
            val response = itemClient.getItemList().execute()
            /*call.enqueue(object: Callback<List<Item>> {

                    override fun onResponse(
                        call: Call<List<Item>>,
                        response: Response<List<Item>>
                    ) {
                        if(response.isSuccessful){
                            response.body()?.let {
                                emit(ResultState.Success(it))
                            }
                            println("response ${response.body()}")
                        }


                    }

                    override fun onFailure(call: Call<List<Item>>, t: Throwable) {

                    }
                })*/



            if (response.isSuccessful) {
                response.body()?.let {
                    emit(ResultState.Success(it))
                }
            }
        } catch (e: Exception) {
            emit(ResultState.Error(e))
        }
    }.flowOn(ioDispatcher)

}