/*
 * Publishing configuration script
 * Usage:
 * 1. Publish SNAPSHOT version: ./gradlew publishToMavenCentral
 * 2. Publish release version: ./gradlew publishToMavenCentral --no-configuration-cache
 */

// Validate required properties
val requiredProperties = listOf(
    "signing.keyId",
    "signing.password", 
    "signing.secretKeyRingFile",
    "mavenCentralUsername",
    "mavenCentralPassword"
)

tasks.register("checkReleaseProperties") {
    doLast {
        val missingProperties = requiredProperties.filter { 
            !project.hasProperty(it) && System.getenv(it.uppercase().replace(".", "_")) == null
        }
        
        if (missingProperties.isNotEmpty()) {
            throw GradleException(
                "Missing required publishing properties: ${missingProperties.joinToString(", ")}\n" +
                "Please configure these properties in local.properties file, or set corresponding environment variables."
            )
        }
        
        println("✅ All required publishing properties are configured")
    }
}

// Check properties before publishing
tasks.withType<PublishToMavenRepository> {
    dependsOn("checkReleaseProperties")
}
