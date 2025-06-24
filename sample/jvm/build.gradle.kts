plugins {
    id("org.jetbrains.kotlin.jvm")
    alias(libs.plugins.kotlin.serialization)
    application
}

dependencies {
    implementation(project(":library"))
    implementation(libs.ktor.client.cio)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
}

application {
    mainClass.set("li.mercury.tushare.sample.jvm.AppKt")
}

tasks.named<JavaExec>("run") {
    jvmArgs = listOf(
        "-Xmx6144m",                    // 最大堆内存6GB
        "-Xms1024m",                    // 初始堆内存1GB
        "-XX:+UseG1GC",                 // 使用G1垃圾收集器
        "-XX:MaxGCPauseMillis=100",     // GC最大暂停时间
        "-XX:+UseStringDeduplication",  // 字符串去重
        "-XX:NewRatio=1",               // 年轻代与老年代比例
        "-XX:MaxMetaspaceSize=512m",    // 元空间大小
        "-Xss2m"                        // 线程栈大小
    )
}
