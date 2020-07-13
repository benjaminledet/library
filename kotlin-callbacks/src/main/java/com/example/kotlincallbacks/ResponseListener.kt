package com.example.kotlincallbacks

interface ResponseListener<T> {

    fun onSuccess(result: T)

    fun onError(exception: Exception)
}
