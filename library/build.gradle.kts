import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "li.mercury.tushare"
version = "1.0.0"

kotlin {
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.cio)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.coroutines.test)
                implementation(libs.koin.test)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.koin.ktor)
                implementation(libs.koin.logger.slf4j)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.koin.test.junit5)
                implementation(project.dependencies.platform(libs.junit.bom))
                implementation(libs.junit.jupiter.api)
                implementation(libs.junit.jupiter.engine)
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), "library", version.toString())

    pom {
        name = "tushare-kmp"
        description = "A Kotlin Multiplatform library for TuShare financial data API"
        inceptionYear = "2025"
        url = "https://github.com/lihenggui/tushare-kmp"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "repo"
            }
        }
        developers {
            developer {
                id = "lihenggui"
                name = "Mercury Li"
                url = "https://github.com/lihenggui"
            }
        }
        scm {
            url = "https://github.com/lihenggui/tushare-kmp"
            connection = "scm:git:git://github.com/lihenggui/tushare-kmp.git"
            developerConnection = "scm:git:ssh://git@github.com/lihenggui/tushare-kmp.git"
        }
    }
}
