(function () { //TODO: move in build.gradle.kts after related updates
    var path = require('path');
    config.entry = [path.resolve(__dirname, "../../../kotlin-js-min/js/main/helloworld.js")];
    config.resolve.modules.push(path.resolve(__dirname, "../../../kotlin-js-min/js/main"));
    config.mode = "production";
})();