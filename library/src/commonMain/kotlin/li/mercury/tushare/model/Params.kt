package li.mercury.tushare.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Params {
    @SerialName("ts_code")
    TS_CODE,

    @SerialName("ann_date")
    ANN_DATE,

    @SerialName("start_date")
    START_DATE,

    @SerialName("end_date")
    END_DATE,

    @SerialName("trade_date")
    TRADE_DATE,

    @SerialName("open")
    OPEN,

    @SerialName("high")
    HIGH,

    @SerialName("low")
    LOW,

    @SerialName("close")
    CLOSE,

    @SerialName("pre_close")
    PRE_CLOSE,

    @SerialName("change")
    CHANGE,

    @SerialName("pct_chg")
    PCT_CHG,

    @SerialName("vol")
    VOL,

    @SerialName("amount")
    AMOUNT,

    @SerialName("name")
    NAME,

    @SerialName("title")
    TITLE,

    @SerialName("url")
    URL,

    @SerialName("rec_time")
    REC_TIME;
}