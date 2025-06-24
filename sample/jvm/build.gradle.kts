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
