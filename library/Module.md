# TuShare Kotlin API Client

TuShare Kotlin API Client是一个为[TuShare金融数据API](https://tushare.pro/)设计的Kotlin多平台客户端库。

## 概述

该库提供了一套完整的API接口，用于访问TuShare提供的中国金融市场数据，包括股票、期货、基金、宏观经济等各类金融数据。

## 主要特性

- **多平台支持**: 支持JVM、Android、iOS、JavaScript、Native等平台
- **协程支持**: 基于Kotlin协程，提供异步非阻塞的API调用
- **类型安全**: 使用Kotlin强类型系统，确保API调用的类型安全
- **易于使用**: 提供简洁直观的API接口
- **高性能**: 基于Ktor HTTP客户端，提供高性能网络通信
- **可配置**: 支持灵活的配置选项，包括超时、重试、代理等

## 架构设计

### 核心组件

- **TuShare**: 主要API接口，整合所有功能模块
- **TuShareApi**: 具体实现类，使用委托模式整合各API模块
- **TuShareConfig**: 配置类，包含所有客户端配置选项
- **HttpTransport**: HTTP传输层，负责网络通信

### API模块

- **新闻模块** (`li.mercury.tushare.api.news`) - 新闻快讯、公告等信息
- **指数模块** (`li.mercury.tushare.api.index`) - 各类指数数据
- **股票基础** (`li.mercury.tushare.api.stock.basic`) - 股票基本信息
- **股票行情** (`li.mercury.tushare.api.stock.market`) - 行情数据
- **股票财务** (`li.mercury.tushare.api.stock.finance`) - 财务数据
- **参考数据** (`li.mercury.tushare.api.stock.reference`) - 股东、概念股等
- **特色数据** (`li.mercury.tushare.api.stock.character`) - 龙虎榜、机构调研等
- **两融数据** (`li.mercury.tushare.api.stock.margin`) - 融资融券数据
- **资金流向** (`li.mercury.tushare.api.stock.flow`) - 资金流向数据
- **打板数据** (`li.mercury.tushare.api.stock.board`) - 涨跌停、连板等数据

## 快速开始

### 1. 添加依赖

```kotlin
dependencies {
    implementation("li.mercury.tushare:tushare-kmp:$version")
    implementation("io.ktor:ktor-client-cio:$ktorVersion") // 选择合适的引擎
}
```

### 2. 创建客户端

```kotlin
val tuShare = TuShare(
    token = "your-api-token",
    timeout = Timeout(socket = 60.seconds)
)
```

### 3. 使用API

```kotlin
// 获取股票基本信息
val stocks = tuShare.getStockBasic(
    StockBasicParams(isHs = "N", listStatus = "L")
)

// 获取日线行情
val dailyData = tuShare.daily(
    DailyParams(tsCode = "000001.SZ", startDate = "20240101")
)
```

## 数据说明

### 数据更新频率
- **实时数据**: 分钟级更新
- **日频数据**: 每日更新，通常在交易日结束后
- **基础数据**: 不定期更新，如公司信息变更时

### 数据权重
- **免费数据**: 无限制访问
- **积分数据**: 需要消耗积分，具体见TuShare官网说明

## 注意事项

1. 使用前需要在[TuShare官网](https://tushare.pro/)注册并获取API Token
2. 请遵守TuShare的使用条款和访问频率限制
3. 建议使用环境变量存储API Token，避免硬编码
4. 在生产环境中请合理配置超时和重试策略

## 许可证

本项目使用 GNU Lesser General Public License v2.1 许可证。

**这是一个非官方库，与TuShare官方无关联也未得到其认可。**