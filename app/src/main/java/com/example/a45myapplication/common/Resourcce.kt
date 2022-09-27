package com.example.a45myapplication.common

sealed class Resourcce<T>(val data: T? = null, val message: String? = null ){
    class Success<T>(data: T) : Resourcce<T>(data)
    class Error<T>(message: String, data: T? = null) : Resourcce<T>(data, message)
    class Loading<T>(data: T? = null) : Resourcce<T>(data)
}


