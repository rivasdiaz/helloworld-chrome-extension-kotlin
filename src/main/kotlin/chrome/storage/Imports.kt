@file:JsQualifier("chrome.storage")

package chrome.storage

/**
 * Items in the sync storage area are synced using Chrome Sync.
 */
external val sync: StorageArea

/**
 * Items in the local storage area are local to each machine.
 */
external val local: StorageArea

/**
 * Items in the managed storage area are set by the domain administrator,
 * and are read-only for the extension; trying to modify this namespace results in an error.
 *
 * Since Chrome 33.
 */
external val managed: StorageArea

external interface StorageArea {

    /**
     * Gets one or more items from storage.
     *
     * @param keys A single key to get, list of keys to get, or a dictionary specifying default values
     *      (see description of the object).
     *      An empty list or object will return an empty result object.
     *      Pass in null to get the entire contents of storage.
     *
     * @param callback Callback with storage items, or on failure (in which case runtime.lastError will be set).
     *      he callback parameter should be a function that looks like this:
     *      function(object items) {...};
     *      where: items: Object with items in their key-value mappings.
     */
    fun get(keys: dynamic = definedExternally, callback: (dynamic) -> Unit)

    /**
     * Sets multiple items.
     *
     * @param items An object which gives each key/value pair to update storage with.
     *      Any other key/value pairs in storage will not be affected.
     *      Primitive values such as numbers will serialize as expected.
     *      Values with a typeof "object" and "function" will typically serialize to {},
     *      with the exception of Array (serializes as expected), Date, and Regex
     *      (serialize using their String representation).
     *
     * @param callback Callback on success, or on failure (in which case runtime.lastError will be set).
     *      If you specify the callback parameter, it should be a function that looks like this:
     *      function() {...};
     */
    fun set(items: dynamic, callback: () -> Unit = definedExternally)

    /**
     * Removes one or more items from storage.
     *
     * @param keys A single key to get, list of keys to remove.
     *
     * @param callback Callback on success, or on failure (in which case runtime.lastError will be set).
     *      If you specify the callback parameter, it should be a function that looks like this:
     *      function() {...};
     */
    fun remove(keys: dynamic, callback: () -> Unit = definedExternally)

    /**
     * Removes all items from storage.
     *
     * @param callback Callback on success, or on failure (in which case runtime.lastError will be set).
     *      If you specify the callback parameter, it should be a function that looks like this:
     *      function() {...};
     */
    fun clear(callback: () -> Unit = definedExternally)
}
