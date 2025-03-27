package li.mercury.tushare.api.index.models

import kotlinx.serialization.Serializable

/**
 * 指数日线行情API请求参数
 *
 * | 名称        | 类型 | 必选 | 描述 |
 * |------------|------|------|------|
 * | ts_code    | str  | Y    | 指数代码，来源指数基础信息接口 |
 * | trade_date | str  | N    | 交易日期 （日期格式：YYYYMMDD，下同） |
 * | start_date | str  | N    | 开始日期 |
 * | end_date   | str  | N    | 结束日期 |
 */
@Serializable
data class IndexDailyParams(
    /** 指数代码，来源指数基础信息接口 */
    val tsCode: String,
    /** 交易日期（日期格式：YYYYMMDD） */
    val tradeDate: String? = null,
    /** 开始日期（日期格式：YYYYMMDD）*/
    val startDate: String? = null,
    /** 结束日期 */
    val endDate: String? = null
) 