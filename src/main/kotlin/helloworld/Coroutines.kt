package helloworld

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine
import kotlin.js.Promise

fun <T> async(block: suspend () -> T) = Promise<T> { resolve, reject ->

    block.startCoroutine(completion = object : Continuation<T> {

        override val context: CoroutineContext = EmptyCoroutineContext

        override fun resume(value: T) {
            resolve(value)
        }

        override fun resumeWithException(exception: Throwable) {
            reject(exception)
        }
    })
}

fun launch(block: suspend () -> Unit) = async(block)

suspend fun <T> Promise<T>.await(): T = suspendCoroutine {
    then(it::resume).catch(it::resumeWithException)
}
