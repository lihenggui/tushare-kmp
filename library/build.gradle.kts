import com.vanniktech.maven.publish.SonatypeHost
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JsModuleKind
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.testing.KotlinJsTest
import org.jetbrains.kotlin.gradle.targets.jvm.tasks.KotlinJvmTest
import org.jetbrains.kotlin.gradle.targets.native.tasks.KotlinNativeTest
import org.jetbrains.kotlin.konan.target.HostManager
import kotlin.apply

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "li.mercury.tushare"
version = "1.0.0"

kotlin {
    explicitApi()
    jvm()
    native()
    jsNode()
    jsWasm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.datetime)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.cio)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.serialization.kotlinx.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.coroutines.test)
                implementation(libs.ktor.client.mock)
                implementation(libs.kotlinx.io.core)
                implementation(libs.kotlinx.io.okio)
                implementation(libs.okio)
                implementation(libs.turbine)
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

tasks.withType<Test> {
    testLogging {
        events(TestLogEvent.STARTED, TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        exceptionFormat = TestExceptionFormat.FULL
        showStandardStreams = false
    }
}

tasks.withType<KotlinJvmTest>().configureEach {
    environment("LIB_ROOT", rootDir)
}

tasks.withType<KotlinNativeTest>().configureEach {
    environment("SIMCTL_CHILD_LIB_ROOT", rootDir)
    environment("LIB_ROOT", rootDir)
}

tasks.withType<KotlinJsTest>().configureEach {
    environment("LIB_ROOT", rootDir.toString())
}

private fun KotlinMultiplatformExtension.native() {
    sourceSets.apply {
        // Native targets
        val nativeMain by creating { dependsOn(getByName("commonMain")) }
        val nativeTest by creating { dependsOn(getByName("commonTest")) }

        // Desktop targets
        val desktopMain by creating { dependsOn(nativeMain) }
        val desktopTest by creating { dependsOn(nativeTest) }
        listOf(linuxX64(), mingwX64()).forEach { target ->
            getByName("${target.name}Main").dependsOn(desktopMain)
            getByName("${target.name}Test").dependsOn(desktopTest)
        }

        // Darwin targets
        if (HostManager.hostIsMac) {
            val darwinMain by creating { dependsOn(nativeMain) }
            val darwinTest by creating { dependsOn(nativeTest) }
            listOf(
                iosX64(),
                iosArm64(),
                iosSimulatorArm64(),
                macosX64(),
                macosArm64(),
                tvosX64(),
                tvosArm64(),
                tvosSimulatorArm64(),
                watchosArm32(),
                watchosArm64(),
                watchosX64(),
                watchosSimulatorArm64(),
            ).forEach { target ->
                getByName("${target.name}Main").dependsOn(darwinMain)
                getByName("${target.name}Test").dependsOn(darwinTest)
            }
        }
    }
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
private fun KotlinMultiplatformExtension.jsWasm() {
    wasmJs {
        nodejs()
    }
}

private fun KotlinMultiplatformExtension.jsNode() {
    js {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    moduleKind.set(JsModuleKind.MODULE_UMD)
                    sourceMap = true
                }
            }
        }
        nodejs()
    }
}
