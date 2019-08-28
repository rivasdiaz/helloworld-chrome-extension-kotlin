rootProject.name = "helloworld"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
            name = "Kotlin EAP"
            url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
        }
    }
}