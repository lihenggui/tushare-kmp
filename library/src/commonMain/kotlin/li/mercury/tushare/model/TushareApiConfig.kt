package li.mercury.tushare.model

sealed class TushareApiConfig(
    val apiName: String,
    val availableParams: Set<String>,
    val availableFields: Set<Fields>,
    val requiredParams: Set<String> = emptySet()
) {
    data object AnnsD : TushareApiConfig(
        apiName = "anns_d",
        availableParams = setOf("ts_code", "ann_date", "start_date", "end_date"),
        availableFields = setOf(Fields.TS_CODE, Fields.ANN_DATE, Fields.NAME, Fields.TITLE, Fields.URL, Fields.REC_TIME),
    )
}

class ParamBuilder {
    private val params = mutableMapOf<String, String>()

    fun annDate(value: String) = apply { params["ann_date"] = value }
    fun tsCode(value: String) = apply { params["ts_code"] = value }
    fun tradeDate(value: String) = apply { params["trade_date"] = value }
    fun startDate(value: String) = apply { params["start_date"] = value }
    fun endDate(value: String) = apply { params["end_date"] = value }

    fun build(config: TushareApiConfig): Params {
        validate(config)
        return Params(
            annDate = params["ann_date"] ?: "",
            tsCode = params["ts_code"] ?: "",
            tradeDate = params["trade_date"] ?: "",
            startDate = params["start_date"] ?: "",
            endDate = params["end_date"] ?: ""
        )
    }

    private fun validate(config: TushareApiConfig) {
        config.requiredParams.forEach { param ->
            require(param in params) { "Missing required parameter: $param" }
        }
    }
}


