package com.example.fetchsample.utils

sealed class ResultState<out T> {
    object Loading : ResultState<Nothing>()
    data class Success<T>(val data: T) : ResultState<T>()
    data class Error(val error: Exception) : ResultState<Nothing>()
}
