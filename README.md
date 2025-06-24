🚧 **项目开发中** - 此项目正在积极开发中，API 可能会发生变化

# TuShare API Kotlin 客户端

[![License](https://img.shields.io/github/license/lihenggui/tushare-kmp?color=yellow)](LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/li.mercury.tushare/tushare-kmp?color=blue&label=Latest)](https://central.sonatype.com/namespace/li.mercury.tushare)

用于 [TuShare 金融数据 API](https://tushare.pro/document/2) 的 Kotlin 客户端，支持多平台和协程。

## 📦 安装配置

### 1. 添加依赖

在你的 `build.gradle` 文件中添加以下依赖：

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation "li.mercury.tushare:tushare-kmp:0.0.1-SNAPSHOT"
}
```

### 2. 选择网络引擎

选择并添加一个 [Ktor 引擎](https://ktor.io/docs/http-client-engines.html) 到你的依赖中：

```groovy
dependencies {
    // Android/JVM
    implementation "io.ktor:ktor-client-okhttp:3.2.0"
    
    // iOS/Native
    implementation "io.ktor:ktor-client-darwin:3.2.0"
    
    // JavaScript
    implementation "io.ktor:ktor-client-js:3.2.0"
}
```



### 多平台项目

在多平台项目中，将 tushare 客户端依赖添加到 `commonMain`：

```kotlin
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("li.mercury.tushare:tushare-kmp:0.0.1-SNAPSHOT")
                // 选择一个适合的 Ktor 引擎
                implementation("io.ktor:ktor-client-cio:3.2.0")
            }
        }
    }
}
```

### Maven

Gradle 是多平台支持所必需的，但你仍然可以在 Maven 项目中使用 JVM 客户端：

```xml
<dependencies>
    <dependency>
        <groupId>li.mercury.tushare</groupId>
        <artifactId>tushare-kmp-jvm</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>io.ktor</groupId>
        <artifactId>ktor-client-okhttp-jvm</artifactId>
        <version>3.2.0</version>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

## ⚡️ 快速开始

> [!NOTE]
> TuShare 建议使用环境变量存储 API token。
> [了解更多最佳实践](https://tushare.pro/document/2)。

创建 `TuShare` 客户端实例：

```kotlin
val tuShare = TuShare(
    token = "your-tushare-token",
    timeout = Timeout(socket = 60.seconds),
    // 其他配置...
)
```

或者使用预配置的 `TuShareConfig`：

```kotlin
val config = TuShareConfig(
    token = apiToken,
    timeout = Timeout(socket = 60.seconds),
    // 其他配置...
)
val tuShare = TuShare(config)
```

### 使用示例

```kotlin
// 获取股票基本信息
val stockBasic = tuShare.stockBasic(
    StockBasicParams(
        isHs = "N",
        listStatus = "L"
    )
)

// 获取日线行情
val daily = tuShare.daily(
    DailyParams(
        tsCode = "000001.SZ",
        startDate = "20240101",
        endDate = "20241231"
    )
)

// 获取指数行情
val indexDaily = tuShare.indexDaily(
    IndexDailyParams(
        tsCode = "000001.SH",
        startDate = "20240101"
    )
)
```

## 🎯 支持的功能

### 沪深股票
- [基础数据](readme/沪深股票/基础数据/) - 股票基本信息、交易日历、股本情况等
- [行情数据](readme/沪深股票/行情数据/) - 日线、周线、月线、分钟行情等
- [财务数据](readme/沪深股票/财务数据/) - 资产负债表、利润表、现金流量表等
- [参考数据](readme/沪深股票/参考数据/) - 股东信息、概念股分类、大宗交易等
- [特色数据](readme/沪深股票/特色数据/) - 龙虎榜、机构调研、筹码分布等
- [打板专题数据](readme/沪深股票/打板专题数据/) - 涨跌停统计、连板天梯、游资数据等
- [两融及融转通](readme/沪深股票/两融及融转通/) - 融资融券、转融通数据
- [资金流向数据](readme/沪深股票/资金流向数据/) - 个股资金流向、板块资金流向等

### 指数行情
- [指数基本信息](readme/指数行情/指数基本信息.md) - 指数基础信息
- [指数日线行情](readme/指数行情/指数日线行情.md) - 各类指数日线数据
- [指数周线行情](readme/指数行情/指数周线行情.md) - 指数周线数据
- [指数月线行情](readme/指数行情/指数月线行情.md) - 指数月线数据
- [申万行业分类](readme/指数行情/申万行业分类.md) - 申万行业分类体系
- [国际指数](readme/指数行情/国际指数.md) - 国际主要指数行情

### 快讯公告
- [新闻快讯](readme/快讯公告/新闻快讯.md) - 实时新闻数据
- [上市公司全量公告](readme/快讯公告/上市公司全量公告.md) - 公司公告信息
- [新闻联播](readme/快讯公告/新闻联播.md) - 新闻联播内容
- [上证E互动](readme/快讯公告/上证E互动.md) - 投资者互动数据
- [深证互动易](readme/快讯公告/深证互动易.md) - 深交所互动数据

## 📚 使用指南

详细的使用指南和示例请查看：

- [基础使用指南](readme/README.md)
- [通过HTTP调取数据](readme/通过HTTP调取数据.md)
- 各个功能模块的详细文档在 [readme](readme/) 目录下

## 🌍 多平台支持

该库支持以下平台：

- **JVM** (Java 8+)
- **Android** (API 21+)
- **iOS** (iOS 13+)
- **macOS** (macOS 10.14+)
- **watchOS** (watchOS 6.0+)
- **tvOS** (tvOS 13+)
- **Linux** (x64)
- **Windows** (x64)
- **JavaScript** (Node.js & Browser)
- **WebAssembly**

## 🔧 配置选项

```kotlin
val tuShare = TuShare(
    token = "your-token",
    host = TuShareHost.TuShare,
    timeout = Timeout(
        socket = 60.seconds,
        connect = 30.seconds,
        request = 120.seconds
    ),
    loggingConfig = LoggingConfig(
        level = LogLevel.INFO,
    ),
    retry = RetryStrategy(
        maxRetries = 3,
    ),
    proxy = Socks(
        host = "proxy.example.com",
        port = 8080
    )
)
```



## 📸 快照版本

[![Snapshot](https://img.shields.io/badge/dynamic/xml?url=https://oss.sonatype.org/service/local/repositories/snapshots/content/li/mercury/tushare/tushare-kmp/maven-metadata.xml&label=snapshot&color=red&query=.//versioning/latest)](https://oss.sonatype.org/content/repositories/snapshots/li/mercury/tushare/tushare-kmp/)

要导入快照版本到你的项目中，在 gradle 文件中添加以下代码：

```groovy
repositories {
    //...
    maven { url 'https://oss.sonatype.org/content/repositories/snapshots/' }
}
```

## ⭐️ 支持

欣赏这个项目？以下是你可以帮助的方式：

1. **Star**: 在右上角给它一个星标，这对我们很重要！
2. **贡献**: 发现问题或有功能想法？提交 PR。
3. **反馈**: 有建议？[开个 issue](https://github.com/lihenggui/tushare-kmp/issues/new)。

## 📄 许可证

TuShare Kotlin API 客户端是在 [GNU Lesser General Public License v2.1](LICENSE) 下开源的软件。

**这是一个非官方库，它与 TuShare 官方无关联也未得到其认可**。欢迎贡献。

---

## 关于 TuShare

[TuShare](https://tushare.pro/) 是一个提供中国金融市场数据的开放平台，包括股票、期货、基金、宏观经济等各类金融数据。该项目是 TuShare API 的非官方 Kotlin 客户端实现。 
