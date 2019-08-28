import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

buildscript {
    val kotlinVersion: String by project
    repositories {
        mavenCentral()
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

plugins {
    val kotlinVersion = "1.3.50"
    kotlin("js") version kotlinVersion
}

repositories {
    mavenCentral()
}

val resultFileName = "popup.js"

kotlin {
    target {
        browser {
            webpackTask {

            }
        }
    }
    sourceSets {
        main {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0")
                implementation(npm("webextension-polyfill"))
            }
        }
    }
}

tasks {
    val extensionFolder = "build/extension"
    val copyBundleFile = register<Copy>("copyBundleFile") {
        from("build/js/packages/helloworld/kotlin/helloworld.js")
        from("build/js/packages_imported/kotlin/1.3.50/kotlin.js")
        from("build/js/packages_imported/kotlinx-coroutines-core/1.3.0/kotlinx-coroutines-core.js")
        into(extensionFolder)
    }
    val copyResources = register<Copy>("copyResources") {
        from("src/main/resources")
        into(extensionFolder)
    }
    val copyPolyfill = register<Copy>("copyPolyfill") {
        from("build/js/node_modules/webextension-polyfill/dist") {
            include("browser-polyfill.js")
        }
        into(extensionFolder)
    }
    val extension = register<Zip>("extension") {
        dependsOn(copyBundleFile, copyPolyfill, copyResources)
        from(extensionFolder)
    }
    assemble {
        dependsOn(extension)
    }
}