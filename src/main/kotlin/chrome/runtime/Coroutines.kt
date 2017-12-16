package chrome.runtime

import kotlin.coroutines.experimental.Continuation

@Suppress("NOTHING_TO_INLINE")
inline fun <T> Continuation<T>.checkRuntimeAndResumeWith(result: T) =
    if (lastError == null) {
        resume(result)
    } else {
        resumeWithException(RuntimeException(lastError))
    }

@Suppress("NOTHING_TO_INLINE")
inline fun Continuation<Unit>.checkRuntimeAndResume() =
        if (lastError == null) {
            resume(Unit)
        } else {
            resumeWithException(RuntimeException(lastError))
        }
