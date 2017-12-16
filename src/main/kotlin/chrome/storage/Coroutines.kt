package chrome.storage

import chrome.runtime.checkRuntimeAndResume
import chrome.runtime.checkRuntimeAndResumeWith
import kotlin.coroutines.experimental.suspendCoroutine

suspend fun StorageArea.getSync(keys: dynamic) =
        suspendCoroutine<dynamic> { continuation ->
            get(keys) { continuation.checkRuntimeAndResumeWith(it) }
        }

suspend fun StorageArea.setSync(items: dynamic) =
        suspendCoroutine<Unit> { continuation ->
            set(items) { continuation.checkRuntimeAndResume() }
        }

suspend fun StorageArea.removeSync(keys: dynamic) =
        suspendCoroutine<Unit> { continuation ->
            remove(keys) { continuation.checkRuntimeAndResume() }
        }

suspend fun StorageArea.clearSync() =
        suspendCoroutine<Unit> { continuation ->
            clear { continuation.checkRuntimeAndResume() }
        }
