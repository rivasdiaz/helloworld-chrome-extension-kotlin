package helloworld

import kotlinx.coroutines.experimental.launch
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventTarget

inline fun EventTarget.onEvent(type: String, noinline listener: (Event) -> Unit) =
        addEventListener(type, listener)

inline fun EventTarget.onEventAsync(type: String, noinline listener: suspend (Event) -> Unit) =
        onEvent(type = type, listener = { event: Event -> launch { listener(event) }})


inline fun EventTarget.onChangeEvent(noinline listener: (Event) -> Unit) =
        onEvent("change", listener)

inline fun EventTarget.onContentLoadedEventAsync(noinline listener: suspend (Event) -> Unit) =
        onEventAsync("DOMContentLoaded", listener)
