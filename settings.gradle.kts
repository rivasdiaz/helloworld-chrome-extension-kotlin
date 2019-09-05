rootProject.name = "helloworld"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
            name = "Kotlin EAP"
            url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
        }
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-dce-js") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
        }

    }
}