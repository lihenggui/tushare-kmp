pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "tushare-kmp"
include(":library")
include(":sample")
include(":sample:jvm")
include(":sample:js")
include(":sample:native")
