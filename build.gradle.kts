import java.net.URL

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply  false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
    id("org.jetbrains.dokka") version "1.9.20"
}

apply(from = "publish.gradle.kts")
apply(from = "generate-docs.gradle.kts")

// Dokka HTML multimodule configuration
tasks.dokkaHtmlMultiModule.configure {
    moduleName.set("TuShare Kotlin API")
    
    outputDirectory.set(file("docs/api"))
    
    includes.from("README.md")
    
    pluginsMapConfiguration.set(
        mapOf(
            "org.jetbrains.dokka.base.DokkaBase" to """
            {
                "customStyleSheets": ["${file("docs/styles.css")}"],
                "customAssets": ["${file("docs/assets")}"],
                "footerMessage": "© 2025 Mercury Li - TuShare Kotlin API Client"
            }
            """.trimIndent()
        )
    )
}
