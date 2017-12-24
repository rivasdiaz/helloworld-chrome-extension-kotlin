### Getting started sample Google Chrome / Mozilla Firefox extension

Chrome Extension sample from Google's Getting Started guide.
Modified to also support Mozilla Firefox.

Documentation [here](https://developer.chrome.com/extensions/getstarted).

This version of the code is as rewriting of the original Google example using Kotlin.
The API has been extended using Kotlin Coroutines.
The extension code has been modified to use coroutines APIs.
Original comments have been kept at the closest place of the original code.

Original version in JavaScript can be seen [here](https://github.com/rivasdiaz/helloworld-chrome-extension-kotlin/tree/52fdf0db02fb636007d3cac652b593ebfc0d78c1).

Original rewrite in Kotlin can be seen [here](https://github.com/rivasdiaz/helloworld-chrome-extension-kotlin/tree/047baa8c4f5011fe9f28bac22e847c2113bd3dce).

Please check this series in Medium that describe this project:

1. [Writing a Chrome extension in Kotlin](https://medium.com/@rivasdiaz/writing-a-chrome-extension-in-kotlin-part-1-e013d431b63f)
2. [Writing a Chrome extension in Kotlin — Using Coroutines](https://medium.com/@rivasdiaz/writing-a-chrome-extension-in-kotlin-using-coroutines-part-2-29175f4d1739)
3. [Writing a Chrome extension in Kotlin — Supporting Firefox and Chrome](https://medium.com/@rivasdiaz/writing-a-chrome-extension-in-kotlin-supporting-firefox-and-chrome-part-3-a5ab0ae58bb4)

##### Building

This project uses gradle. To build it, execute the following:

```
gradlew clean assemble
```

Unbundled extension will be generated inside `build/extension`.
This folder can be used to install in Chrome.

Zipped extension will be generated inside `build/distributions`.
The zip generated inside that folder can be used to install in Firefox.

##### Installing the extension

###### Google Chrome

1. Go to Extensions
2. Enable "Developer Mode"
3. Click on "Load unpacked extension..."
4. Select the folder `${project}/build/extension` and open it.

If changes are made and the extension is recompiled, make sure to update the extension:

1. Go to Extensions
2. Make sure "Developer Mode" is enabled
3. Click on "Update extensions now"

Make sure to check Google documentation for more details.

###### Mozilla Firefox

The extension needs to be uploaded to Mozilla Add-ons website for the extension to work in Firefox.

Please follow instructions [here](https://developer.mozilla.org/en-US/Add-ons/Distribution/Submitting_an_add-on).

##### Testing the extension

Upon installation a a new extension is added to Chrome/Firefox with the icon ![hello](src/main/web/icon.png "Getting started example")

Clicking the icon will open a small popup that will allow changing active page background color.

Check Google's [Getting started guide](https://developer.chrome.com/extensions/getstarted) for more details.
