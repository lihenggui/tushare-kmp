package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 股票基本信息
 */
@Serializable
data class StockBasicResult(
    @SerialName("ts_code") val tsCode: String,
    val symbol: String,
    val name: String,
    val area: String? = null,
    val industry: String? = null,
    val fullname: String? = null,
    val enname: String? = null,
    val cnspell: String? = null,
    val market: String? = null,
    val exchange: String? = null,
    @SerialName("curr_type") val currType: String? = null,
    @SerialName("list_status") val listStatus: String? = null,
    @SerialName("list_date") val listDate: String? = null,
    @SerialName("delist_date") val delistDate: String? = null,
    @SerialName("is_hs") val isHs: String? = null,
    @SerialName("act_name") val actName: String? = null,
    @SerialName("act_ent_type") val actEntType: String? = null,
)
