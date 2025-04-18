# 实时盘口 TICK 快照（爬虫版）

## 接口名称：`realtime_quote`

## 接口说明
- 获取 **A股实时行情**，数据来自 **网络爬虫**，不进入 **Tushare 服务器**。
- **Tushare 版本要求**：**>= 1.3.3**
- **数据源**：
  - **新浪财经（sina）**：支持 **多个股票** 同时查询（最多 50 个）。
  - **东方财富（dc）**：仅支持 **单个股票** 查询。

## **权限**
- **0 积分** 完全开放，但需要 **Tushare 账号**。
- **Tushare 不对数据内容和质量负责**，仅供 **研究和学习**，如用于 **商业目的**，请自行解决 **合规问题**。

---

## **输入参数**

| 名称      | 类型  | 必选 | 描述 |
|----------|------|------|------------------------------|
| ts_code  | str  | N    | 股票代码（如 `000001.SZ` 表示平安银行，`000001.SH` 表示上证指数） |
| src      | str  | N    | 数据源（`sina` - 新浪财经，`dc` - 东方财富，默认 `sina`） |

> **src 数据源说明**：
> - `sina`（新浪财经）：支持 **多个股票** 同时查询（最多 50 个）。
> - `dc`（东方财富）：仅支持 **单个股票** 查询。

---

## **输出参数**

| 名称       | 类型  | 描述 |
|-----------|------|----------------|
| name      | str  | 股票名称 |
| ts_code   | str  | 股票代码 |
| date      | str  | 交易日期 |
| time      | str  | 交易时间 |
| open      | float | 开盘价 |
| pre_close | float | 昨收价 |
| price     | float | 现价 |
| high      | float | 今日最高价 |
| low       | float | 今日最低价 |
| bid       | float | 竞买价（买一报价） |
| ask       | float | 竞卖价（卖一报价） |
| volume    | int   | 成交量（`sina` 为 **股**，`dc` 为 **手**） |
| amount    | float | 成交金额（元 CNY） |
| b1_v      | float | **委买一**（量，单位：手） |
| b1_p      | float | **委买一**（价，单位：元） |
| b2_v      | float | **委买二**（量） |
| b2_p      | float | **委买二**（价） |
| b3_v      | float | **委买三**（量） |
| b3_p      | float | **委买三**（价） |
| b4_v      | float | **委买四**（量） |
| b4_p      | float | **委买四**（价） |
| b5_v      | float | **委买五**（量） |
| b5_p      | float | **委买五**（价） |
| a1_v      | float | **委卖一**（量，单位：手） |
| a1_p      | float | **委卖一**（价，单位：元） |
| a2_v      | float | **委卖二**（量） |
| a2_p      | float | **委卖二**（价） |
| a3_v      | float | **委卖三**（量） |
| a3_p      | float | **委卖三**（价） |
| a4_v      | float | **委卖四**（量） |
| a4_p      | float | **委卖四**（价） |
| a5_v      | float | **委卖五**（量） |
| a5_p      | float | **委卖五**（价） |

---

## **接口示例**

### **新浪财经（支持多个股票）**
```python
import tushare as ts

# 设置 Tushare Token（请在 Tushare 个人中心获取）
ts.set_token('你的token')

# 获取 600000.SH（浦发银行）、000001.SZ（平安银行）、000001.SH（上证指数）的实时行情（新浪数据）
df = ts.realtime_quote(ts_code='600000.SH,000001.SZ,000001.SH')
```

---

### **东方财富（仅支持单个股票）**
```python
# 获取 600000.SH（浦发银行）的实时行情（东方财富数据）
df = ts.realtime_quote(ts_code='600000.SH', src='dc')
```

---

## **数据样例**

| name   | ts_code   | date     | time     | open  | pre_close | price  | high  | low   | bid   | ask   | volume  | amount  | b1_v  | b1_p  | a1_v  | a1_p  |
|--------|----------|----------|----------|-------|-----------|--------|-------|-------|-------|-------|---------|---------|-------|-------|-------|-------|
| 浦发银行 | 600000.SH | 20231222 | 15:00:00 | 6.570 | 6.570     | 6.580  | 6.590 | 6.560 | 6.580 | 6.590 | 1234567 | 9876543 | 1000  | 6.580 | 2000  | 6.590 |
| 平安银行 | 000001.SZ | 20231222 | 15:00:00 | 9.190 | 9.170     | 9.200  | 9.210 | 9.180 | 9.200 | 9.210 | 2345678 | 8765432 | 1500  | 9.200 | 2500  | 9.210 |
| 上证指数 | 000001.SH | 20231222 | 15:30:39 | 2919.29 | 2918.71 | 2914.78 | 2920.00 | 2910.00 | - | - | 0 | 0 | 0 | 0 | 0 | 0 |
