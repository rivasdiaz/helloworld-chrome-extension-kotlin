package chrome.tabs

const val MUTED_INFO_REASON__USER = "user"
const val MUTED_INFO_REASON__CAPTURE = "capture"
const val MUTED_INFO_REASON__EXTENSION = "extension"

const val RUN_AT__DOCUMENT_START = "document_start"
const val RUN_AT__DOCUMENT_END = "document_end"
const val RUN_AT__DOCUMENT_IDLE = "document_idle"

const val TAB_STATUS__LOADING = "loading"
const val TAB_STATUS__COMPLETE = "complete"

const val WINDOW_TYPE__NORMAL = "normal"
const val WINDOW_TYPE__POPUP = "popup"
const val WINDOW_TYPE__PANEL = "panel"
const val WINDOW_TYPE__APP = "app"
const val WINDOW_TYPE__DEVTOOLS = "devtools"

@Suppress("UNCHECKED_CAST_TO_NATIVE_INTERFACE")
inline fun QueryInfo(block: QueryInfo.() -> Unit) =
        (js("{}") as QueryInfo).apply(block)

@Suppress("UNCHECKED_CAST_TO_NATIVE_INTERFACE")
inline fun ExecuteScriptDetails(block: ExecuteScriptDetails.() -> Unit) =
        (js("{}") as ExecuteScriptDetails).apply(block)
