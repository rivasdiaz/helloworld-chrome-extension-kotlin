@file:JsQualifier("chrome.tabs")

package chrome.tabs

external fun query(queryInfo: QueryInfo, callback: (Array<Tab>) -> Unit)
external fun executeScript(
        tabId: Int? = definedExternally,
        details: ExecuteScriptDetails,
        callback: ((Array<dynamic>) -> Unit)? = definedExternally
)

external val TAB_ID_NONE: Int = definedExternally

external interface QueryInfo {

    /**
     * Whether the tabs are active in their windows.
     * */
    var active: Boolean?

    /**
     * Whether the tabs are pinned.
     * */
    var pinned: Boolean?

    /**
     * Whether the tabs are audible.
     *
     * Since Chrome 45.
     * */
    var audible: Boolean?

    /**
     * Whether the tabs are muted.
     *
     * Since Chrome 45.
     * */
    var muted: Boolean?

    /**
     * Whether the tabs are highlighted.
     * */
    var highlighted: Boolean?

    /**
     * Whether the tabs are discarded.
     * A discarded tab is one whose content has been unloaded from memory,
     * but is still visible in the tab strip.
     * Its content gets reloaded the next time it's activated.
     *
     * Since Chrome 54.
     */
    var discarded: Boolean?

    /**
     * Whether the tabs can be discarded automatically by the browser when resources are low.
     *
     * Since Chrome 54.
     */
    var autoDiscardable: Boolean?

    /**
     * Whether the tabs are in the current window.
     * */
    var currentWindow: Boolean?

    /**
     * Whether the tabs are in the last focused window.
     * */
    var lastFocusedWindow: Boolean?

    /**
     * Whether the tabs have completed loading.
     * */
    var status: String?

    /**
     * Match page titles against a pattern.
     * Note that this property is ignored if the extension doesn't have the "tabs" permission.
     */
    var title: String?

    /**
     * Match tabs against one or more URL patterns.
     * Note that fragment identifiers are not matched.
     * Note that this property is ignored if the extension doesn't have the "tabs" permission.
     */
    var url: String? //TODO string or array of string (optional)

    /** The ID of the parent window, or windows.WINDOW_ID_CURRENT for the current window. */
    var windowId: Int?

    /** The type of window the tabs are in. */
    var windowType: String?

    /** The position of the tabs within their windows. */
    var index: Int?

}

external interface Tab {

    /**
     * The ID of the tab. Tab IDs are unique within a browser session.
     * Under some circumstances a Tab may not be assigned an ID, for example when querying foreign tabs using the sessions API, in which case a session ID may be present.
     * Tab ID can also be set to chrome.tabs.TAB_ID_NONE for apps and devtools windows.
     */
    val id: Int?

    /**
     * The zero-based index of the tab within its window.
     */
    val index: Int

    /**
     * The ID of the window the tab is contained within.
     */
    val windowId: Int

    /**
     * The ID of the tab that opened this tab, if any. This property is only present if the opener tab still exists.
     */
    val openerTabId: Int?

    /**
     * Whether the tab is highlighted.
     */
    val highlighted: Boolean

    /**
     * Whether the tab is active in its window. (Does not necessarily mean the window is focused.)
     */
    val active: Boolean

    /**
     * Whether the tab is pinned.
     */
    val pinned: Boolean

    /**
     *Whether the tab has produced sound over the past couple of seconds (but it might not be heard if also muted).
     * Equivalent to whether the speaker audio indicator is showing.
     *
     * Since Chrome 45.
     */
    val audible: Boolean?

    /**
     * Whether the tab is discarded.
     * A discarded tab is one whose content has been unloaded from memory, but is still visible in the tab strip.
     * Its content gets reloaded the next time it's activated.
     *
     * Since Chrome 54.
     */
    val discarded: Boolean

    /**
     * Whether the tab can be discarded automatically by the browser when resources are low.
     *
     * Since Chrome 54.
     */
    val autoDiscardable: Boolean

    /**
     * Current tab muted state and the reason for the last state change.
     *
     * Since Chrome 46.
     */
    val mutedInfo: MutedInfo?

    /**
     * The URL the tab is displaying.
     * This property is only present if the extension's manifest includes the "tabs" permission.
     */
    val url: String?

    /**
     * The title of the tab.
     * This property is only present if the extension's manifest includes the "tabs" permission.
     */
    val title: String?

    /**
     * The URL of the tab's favicon.
     * This property is only present if the extension's manifest includes the "tabs" permission.
     * It may also be an empty string if the tab is loading.
     */
    val favIconUrl: String?

    /**
     * Either loading or complete.
     */
    val status: String?

    /**
     * Whether the tab is in an incognito window.
     */
    val incognito: Boolean

    /**
     * The width of the tab in pixels.
     *
     * Since Chrome 31.
     */
    val width: Int?

    /**
     * The height of the tab in pixels.
     *
     * Since Chrome 31.
     */
    val height: Int?

    /**
     * The session ID used to uniquely identify a Tab obtained from the sessions API.
     *
     * Since Chrome 31.
     */
    val sessionId: String?
}

external interface MutedInfo {

    /**
     * Whether the tab is prevented from playing sound (but hasn't necessarily recently produced sound).
     * Equivalent to whether the muted audio indicator is showing.
     */
    val muted: Boolean

    /**
     * The reason the tab was muted or unmuted.
     * Not set if the tab's mute state has never been changed.
     */
    val reason: String?

    /**
     * The ID of the extension that changed the muted state.
     * Not set if an extension was not the reason the muted state last changed.
     */
    val extensionId: String?
}

external interface ExecuteScriptDetails {

    /**
     * JavaScript or CSS code to inject.
     *
     * Warning:
     * Be careful using the code parameter.
     * Incorrect use of it may open your extension to cross site scripting attacks.
     */
    var code: String?

    /** JavaScript or CSS file to inject. */
    var file: String?

    /**
     * If allFrames is true, implies that the JavaScript or CSS should be injected into all frames of current page.
     * By default, it's false and is only injected into the top frame.
     * If true and frameId is set, then the code is inserted in the selected frame and all of its child frames.
     */
    var allFrames: Boolean?

    /**
     * The frame where the script or CSS should be injected. Defaults to 0 (the top-level frame).
     * Since Chrome 39.
     */
    var frameId: Int?

    /**
     * If matchAboutBlank is true, then the code is also injected in about:blank and about:srcdoc frames if your extension has access to its parent document.
     * Code cannot be inserted in top-level about:-frames. By default it is false.
     * Since Chrome 39.
     */
    var matchAboutBlank: Boolean?

    /**
     * The soonest that the JavaScript or CSS will be injected into the tab. Defaults to "document_idle".
     */
    var runAt: String?
}
