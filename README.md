### Getting started sample Google Chrome extension

Chrome Extension sample from Google's Getting Started guide.

Documentation [here](https://developer.chrome.com/extensions/getstarted).

This version of the code is copied from the original Google example.

##### Building

This project uses gradle. To build it, execute the following:

```
gradlew clean assemble
```

Unbundled extension will be generated inside `build/extension`.

To install in Chrome:

1. Go to Extensions
2. Enable "Developer Mode"
3. Click on "Load unpacked extension..."
4. Select the folder `${project}/build/extension` and open it.

If changes are made and the extension is recompiled, make sure to update the extension:

1. Go to Extensions
2. Make sure "Developer Mode" is enabled
3. Click on "Update extensions now"

Make sure to check Google documentation for more details.

##### Testing the extension

Upon installation a a new extension is added to Chrome with the icon ![hello](src/main/web/icon.png "Getting started example")

Clicking the icon will open a small popup that will allow changing active page background color.

Check Google's [Getting started guide](https://developer.chrome.com/extensions/getstarted) for more details.
