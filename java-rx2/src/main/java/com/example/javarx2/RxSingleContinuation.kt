package com.example.javarx2

import io.reactivex.SingleEmitter
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class RxSingleContinuation<T>(private val emitter: SingleEmitter<T>): Continuation<T> {

    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resumeWith(result: Result<T>) {
        if (result.isSuccess) {
            emitter.onSuccess(result.getOrNull()!!)
        } else {
            emitter.onError(result.exceptionOrNull()!!)
        }
    }
}