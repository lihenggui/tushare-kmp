plugins {
    kotlin("multiplatform")
}

kotlin {
    js {
        nodejs {
            binaries.executable()
        }
    }

    // Option #1. Declare dependencies in the `sourceSets` block:
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":library"))
                implementation(libs.kotlinx.datetime)
                implementation(libs.kotlinx.coroutines.core)
            }
        }
    }
}
