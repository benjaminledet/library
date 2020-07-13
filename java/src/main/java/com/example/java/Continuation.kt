package com.example.java

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class Continuation<in T> : kotlin.coroutines.Continuation<T> {

    override val context: CoroutineContext = EmptyCoroutineContext

    abstract fun resume(value: T)

    abstract fun resumeWithException(exception: Throwable)

    override fun resumeWith(result: Result<T>) = result.fold(::resume, ::resumeWithException)

}