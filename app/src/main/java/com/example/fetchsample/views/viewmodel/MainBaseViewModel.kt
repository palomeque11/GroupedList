package com.example.fetchsample.views.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchsample.rest.ItemClient
import com.example.fetchsample.model.domain.Item
import com.example.fetchsample.useCase.GetItemListCase
import com.example.fetchsample.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class MainBaseViewModel @Inject constructor(
    private val getItemListCase: GetItemListCase
) : ViewModel() {

    private val _characters: MutableLiveData<ResultState<List<Item>>> =
        MutableLiveData(ResultState.Loading)
    val characters: LiveData<ResultState<List<Item>>> get() = _characters


    fun getItemList(){
        viewModelScope.launch {
            getItemListCase().collect {
                _characters.postValue(it)
            }
        }
    }
}

