package com.example.kotlincallbacks

import com.example.core.Client
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Use this function if you do not want to use coroutines (thought it's not recommended)
 * It transform a coroutine into a listener
 */
fun <T>Client.call(responseListener: ResponseListener<T>, block: suspend Client.() -> T) {
    GlobalScope.launch {
        try {
            val result = block.invoke(this@call)
            responseListener.onSuccess(result)
        } catch (e: Exception) {
            responseListener.onError(e)
        }
    }
}