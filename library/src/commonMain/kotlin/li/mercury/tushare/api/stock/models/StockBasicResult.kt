package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票基本信息返回对象类
 */
@Serializable
data class StockBasicResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票代码 */
    val symbol: String,
    /** 股票名称 */
    val name: String,
    /** 地域 */
    val area: String? = null,
    /** 所属行业 */
    val industry: String? = null,
    /** 股票全称 */
    val fullname: String? = null,
    /** 英文全称 */
    val enname: String? = null,
    /** 拼音缩写 */
    val cnspell: String? = null,
    /** 市场类型（主板/创业板/科创板/CDR/北交所） */
    val market: String? = null,
    /** 交易所代码（SSE上交所 SZSE深交所 BSE北交所） */
    val exchange: Exchange? = null,
    /** 交易货币 */
    @SerialName("curr_type")
    val currType: String? = null,
    /** 上市状态 L上市 D退市 P暂停上市 */
    @SerialName("list_status")
    val listStatus: ListStatus? = null,
    /** 上市日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("list_date")
    val listDate: LocalDate? = null,
    /** 退市日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("delist_date")
    val delistDate: LocalDate? = null,
    /** 是否沪深港通标的，N否 H沪股通 S深股通 */
    @SerialName("is_hs")
    val isHs: HsTarget? = null,
    /** 实控人名称 */
    @SerialName("act_name")
    val actName: String? = null,
    /** 实控人企业性质 */
    @SerialName("act_ent_type")
    val actEntType: String? = null,
)
