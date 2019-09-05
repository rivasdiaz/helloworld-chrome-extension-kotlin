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
    kotlin("multiplatform") version kotlinVersion
    id("kotlin-dce-js") version kotlinVersion
}

repositories {
    mavenCentral()
}

val resultFileName = "popup.js"
val minifiedPath = "build/kotlin-js-min/main"

kotlin {
    js {
        browser {
            webpackTask {
                archiveFileName = resultFileName
                sourceMaps = false
                report = true
            }
        }
        sourceSets {
            val jsMain by getting {
                dependencies {
                    implementation(kotlin("stdlib-js"))
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.0")
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0")
                    runtimeOnly(npm("webextension-polyfill", "0.4.0"))
                }
            }
        }
    }
}

tasks {
    val extensionFolder = "build/extension"

    val runDceJsKotlin by getting

    val jsBrowserWebpack by getting {
        dependsOn(runDceJsKotlin)
    }

    val copyBundleFile = register<Copy>("copyBundleFile") {
        dependsOn(jsBrowserWebpack)
        from("build/distributions") {
            include("*.js")
        }
        into(extensionFolder)
    }
    val copyResources = register<Copy>("copyResources") {
        from("src/jsMain/resources")
        into(extensionFolder)
    }
    val copyPolyfill = register<Copy>("copyPolyfill") {
        from("build/js/node_modules/webextension-polyfill/dist") {
            include("browser-polyfill.min.js")
        }
        into(extensionFolder)
    }
    val extension = register<Zip>("extension") {
        dependsOn(copyBundleFile, copyPolyfill, copyResources)
        from(extensionFolder)
        into("build")
    }
    assemble {
        dependsOn(extension)
    }
}