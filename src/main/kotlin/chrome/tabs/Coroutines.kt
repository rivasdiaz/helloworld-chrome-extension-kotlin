package chrome.tabs

import chrome.runtime.checkRuntimeAndResumeWith
import kotlin.coroutines.experimental.suspendCoroutine

suspend fun querySync(queryInfo: QueryInfo) =
    suspendCoroutine<Array<Tab>> { continuation ->
        query(queryInfo) { continuation.checkRuntimeAndResumeWith(it) }
    }

suspend fun executeScriptSync(tabId: Int?, details: ExecuteScriptDetails) =
    suspendCoroutine<dynamic> { continuation ->
        executeScript(tabId, details) { continuation.checkRuntimeAndResumeWith(it) }
    }

suspend fun executeScriptSync(details: ExecuteScriptDetails) =
    suspendCoroutine<dynamic> { continuation ->
        executeScript(details = details) { continuation.checkRuntimeAndResumeWith(it) }
    }
