plugins {
    alias(libs.plugins.kotlin.multiplatform) apply  false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
}

apply(from = "publish.gradle.kts")
