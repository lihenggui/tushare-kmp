# 通过HTTP调取数据

长久以来，Tushare 一直以固定的 Python SDK 方式为大家提供数据服务。

虽然在基于 Python 的数据分析和 Python 的量化策略开发很方便，但习惯用其他语言的同学们表示了“抗议”，于是在 Tushare 的 Github 开发组里，衍生出了各种语言版本的 Tushare，比如 Ruby Tushare，nodejs Tushare...

尽管多出了不少版本，但数据还是不能统一管理，Tushare 的数据标准没有建立起来。

于是，我们在最近发布的 Tushare Pro 版里，增加对 HTTP RESTful API 的支持，用户可以通过标准协议，获得想要的数据，而且与编程语言无关。

## HTTP API 说明

在 [tushare.pro](http://tushare.pro) 网站上，我们在平台介绍的“调取数据”部分，已经对 HTTP 协议的数据获取做了说明，这里再次详细的向大家介绍一下，尽量让大家多一点的了解如何通过 HTTP 的方式获取 Tushare 数据。

Tushare HTTP 数据获取的方式，我们采用了 `POST` 的机制，通过提交 JSON body 参数，就可以获得您想要的数据。具体参数说明如下：

### 输入参数

- **api_name**：接口名称，比如 `stock_basic`
- **token**：用户唯一标识，可通过登录 pro 网站获取
- **params**：接口参数，如 `daily` 接口中 `start_date` 和 `end_date`
- **fields**：字段列表，用于接口获取指定的字段，以逗号分隔，如 `"open,high,low,close"`

> token 的获取，请参考之前公众号文章《开启 Pro 体验的正确打开方式》，如需注册用户，可直接点击“阅读原文”完成。

### 输出参数

- **code**：接口返回码，`2002` 表示权限问题。
- **msg**：错误信息，比如“系统内部错误”，“没有权限”等
- **data**：数据，`data` 里包含 `fields` 和 `items` 字段，分别为字段和数据内容

以下，我们从几个方面来介绍具体的使用过程。

## API 工具快速检测

如果想简单快速获得数据 API 的效果，检测一下可用性，又不想写代码的话，Postman 这个工具或许可以派上用场。

运行 Postman，选择 `POST` 方式，在 API 地址栏里输入：

```
http://api.tushare.pro
```

然后在下面点击 `body`，输入 JSON 格式的参数。

之后，点击“Send”按钮，我们可以在结果栏目里看到调取 API 的最终效果。

## 代码快速检测

有的程序员可能更喜欢用代码的方式来检查 API 的效果，更加直接，简单，高效。我们可以借助 `cURL` 工具来实现通过命令行方式来检测。

```bash
curl -X POST -d '{"api_name": "stock_basic", "token": "xxxxxxxx", "params": {"list_stauts":"L"}, "fields": "ts_code,name,area,industry,list_date"}' http://api.tushare.pro
```

（按住屏幕滑动可浏览全部代码）

在控制台执行后，我们就可以看到如下数据效果：

```json
{
    "code": 0,
    "msg": null,
    "data": {
        "fields": [
            "ts_code",
            "name",
            "area",
            "industry",
            "list_date"
        ],
        "items": [
            [
                "000001.SZ",
                "平安银行",
                "深圳",
                "银行",
                "19910403"
            ],
            [
                "000002.SZ",
                "万科A",
                "深圳",
                "全国地产",
                "19910129"
            ],
            [
                "000004.SZ",
                "国农科技",
                "深圳",
                "生物制药",
                "19910114"
            ],
            [
                "000005.SZ",
                "世纪星源",
                "深圳",
                "房产服务",
                "19901210"
            ],
            [
                "000006.SZ",
                "深振业A",
                "深圳",
                "区域地产",
                "19920427"
            ],
            [
                "000007.SZ",
                "全新好",
                "深圳",
                "酒店餐饮",
                "19920413"
            ],
            [
                "000008.SZ",
                "神州高铁",
                "北京",
                "运输设备",
                "19920507"
            ]
            ...
        ]
    }
}
```

## Python 调取示例

前面已经提到，HTTP RESTful API 的好处就是跟编程语言无关，基本上所有编程语言都可以调取。

由于编程环境太多，这里只拿 Python 作为示例，其他语言的实现，请各位用户自行查找网络资源完成，相信绝大多数会编程的用户都能轻松搞定。

其实 Tushare Pro 新版的 SDK，正是利用 HTTP 方式来获取数据的，虽然我们也提供了 TCP 的方式，但是 HTTP 目前运行良好，稳定性已经得到了验证。

以下就是相关的核心代码，有兴趣的朋友可以访问 Tushare 的 Github 下载完整代码。

```python
def req_http_api(self, req_params):
    req = Request(
        self.__http_url,
        json.dumps(req_params).encode('utf-8'),
        method='POST'
    )

    res = urlopen(req)
    result = json.loads(res.read().decode('utf-8'))

    if result['code'] != 0:
        raise Exception(result['msg'])

    return result['data']


def query(self, api_name, fields='', **kwargs):
    req_params = {
        'api_name': api_name,
        'token': self.__token,
        'params': kwargs,
        'fields': fields
    }

    if self.__protocol == 'tcp':
        data = self.req_zmq_api(req_params)
    elif self.__protocol == 'http':
        data = self.req_http_api(req_params)
    else:
        raise Warning('{} is unsupported protocol'.format(self.__protocol))

    columns = data['fields']
    items = data['items']

    return pd.DataFrame(items, columns=columns)
```
