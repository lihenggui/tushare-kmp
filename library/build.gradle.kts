/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 * Copyright (C) 2025 Mercury Li
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JsModuleKind
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.testing.KotlinJsTest
import org.jetbrains.kotlin.gradle.targets.jvm.tasks.KotlinJvmTest
import org.jetbrains.kotlin.gradle.targets.native.tasks.KotlinNativeTest
import org.jetbrains.kotlin.konan.target.HostManager
import java.net.URL

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.vanniktech.mavenPublish)
    id("org.jetbrains.dokka") version "1.9.20"
}

group = project.property("GROUP") as String
version = project.property("VERSION_NAME") as String

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

// Dokka configuration
tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
    dokkaSourceSets {
        named("commonMain") {
            displayName.set("TuShare Kotlin API")
            platform.set(org.jetbrains.dokka.Platform.common)
            
            // Include module description
            includes.from("Module.md")
            
            sourceLink {
                localDirectory.set(projectDir.resolve("src/commonMain/kotlin"))
                remoteUrl.set(URL("https://github.com/lihenggui/tushare-kmp/tree/main/library/src/commonMain/kotlin"))
                remoteLineSuffix.set("#L")
            }
            
            externalDocumentationLink {
                url.set(URL("https://kotlinlang.org/api/kotlinx.coroutines/"))
            }
            
            externalDocumentationLink {
                url.set(URL("https://kotlinlang.org/api/kotlinx.serialization/"))
            }
            
            externalDocumentationLink {
                url.set(URL("https://api.ktor.io/"))
            }
            
            // Samples configuration
            samples.from("src/commonMain/kotlin")
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    pom {
        name.set(project.property("POM_NAME") as String)
        description.set(project.property("POM_DESCRIPTION") as String)
        inceptionYear.set(project.property("POM_INCEPTION_YEAR") as String)
        url.set(project.property("POM_URL") as String)
        licenses {
            license {
                name.set(project.property("POM_LICENSE_NAME") as String)
                url.set(project.property("POM_LICENSE_URL") as String)
                distribution.set(project.property("POM_LICENSE_DIST") as String)
            }
        }
        developers {
            developer {
                id.set(project.property("POM_DEVELOPER_ID") as String)
                name.set(project.property("POM_DEVELOPER_NAME") as String)
                url.set(project.property("POM_DEVELOPER_URL") as String)
            }
        }
        scm {
            url.set(project.property("POM_SCM_URL") as String)
            connection.set(project.property("POM_SCM_CONNECTION") as String)
            developerConnection.set(project.property("POM_SCM_DEV_CONNECTION") as String)
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
