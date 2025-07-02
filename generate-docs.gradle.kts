/*
 * TuShare Kotlin API Documentation Generation Script
 * 
 * This script provides tasks for generating and deploying API documentation
 * using Dokka and GitHub Pages.
 */

tasks.register("generateDocs") {
    group = "documentation"
    description = "Generate API documentation using Dokka"
    
    dependsOn("dokkaHtmlMultiModule")
    
    doLast {
        println("✅ API documentation generated successfully!")
        println("📁 Documentation location: ${project.file("docs/api")}")
        println("🌐 To serve locally, run: ./gradlew serveDocs")
    }
}

tasks.register("serveDocs") {
    group = "documentation"
    description = "Serve documentation locally for preview"
    
    dependsOn("generateDocs")
    
    doLast {
        val docsDir = project.file("docs/api")
        if (docsDir.exists()) {
            println("🚀 Starting local documentation server...")
            println("📖 Documentation will be available at: http://localhost:8080")
            println("⏹️  Press Ctrl+C to stop the server")
            
            // Start simple HTTP server using Python (available on most systems)
            val process = ProcessBuilder()
                .directory(docsDir)
                .command("python3", "-m", "http.server", "8080")
                .start()
                
            // Handle Ctrl+C gracefully
            Runtime.getRuntime().addShutdownHook(Thread {
                process.destroy()
                println("\n🛑 Documentation server stopped")
            })
            
            process.waitFor()
        } else {
            throw GradleException("Documentation not found. Run 'generateDocs' first.")
        }
    }
}

tasks.register("cleanDocs") {
    group = "documentation"
    description = "Clean generated documentation"
    
    doLast {
        val docsDir = project.file("docs/api")
        if (docsDir.exists()) {
            docsDir.deleteRecursively()
            println("🗑️  Documentation cleaned")
        }
    }
}

tasks.register("publishDocs") {
    group = "documentation"
    description = "Publish documentation to GitHub Pages"
    
    dependsOn("generateDocs")
    
    doLast {
        val docsDir = project.file("docs/api")
        if (!docsDir.exists()) {
            throw GradleException("Documentation not found. Run 'generateDocs' first.")
        }
        
        println("📤 Publishing documentation to GitHub Pages...")
        println("ℹ️  Make sure you have configured GitHub Pages in your repository settings")
        println("ℹ️  GitHub Pages should be set to use the 'docs' folder from the main branch")
        
        // Create .nojekyll file to prevent Jekyll processing
        project.file("docs/.nojekyll").createNewFile()
        
        // Create index.html redirect to API docs
        val indexHtml = """
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="utf-8">
                <title>TuShare Kotlin API Documentation</title>
                <meta http-equiv="refresh" content="0; url=./api/index.html">
                <link rel="canonical" href="./api/index.html">
            </head>
            <body>
                <h1>TuShare Kotlin API Documentation</h1>
                <p>Redirecting to <a href="./api/index.html">API documentation</a>...</p>
            </body>
            </html>
        """.trimIndent()
        
        project.file("docs/index.html").writeText(indexHtml)
        
        println("✅ Documentation prepared for GitHub Pages")
        println("🔗 After pushing to GitHub, your docs will be available at:")
        println("   https://yourusername.github.io/tushare-kmp/")
    }
}

// Configure clean task to also clean docs if it exists
tasks.matching { it.name == "clean" }.configureEach {
    dependsOn("cleanDocs")
}