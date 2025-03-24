package li.mercury.tushare.model

sealed class TushareApiConfig(
    val apiName: String,
    val availableParams: Set<Params>,
    val availableFields: Set<Fields>,
    val requiredParams: Set<Params> = emptySet()
) {
    data object AnnsD : TushareApiConfig(
        apiName = "anns_d",
        availableParams = setOf(Params.TS_CODE, Params.ANN_DATE, Params.START_DATE, Params.END_DATE),
        availableFields = setOf(Fields.TS_CODE, Fields.ANN_DATE, Fields.NAME, Fields.TITLE, Fields.URL, Fields.REC_TIME),
    )
}

class ParamBuilder {
    private val params = mutableMapOf<Params, String>()

    fun annDate(value: String) = paramBuilder(Params.ANN_DATE, value)

    fun tsCode(value: String) = paramBuilder(Params.TS_CODE, value)

    fun tradeDate(value: String) = paramBuilder(Params.TRADE_DATE, value)

    fun startDate(value: String) = paramBuilder(Params.START_DATE, value)

    fun endDate(value: String) = paramBuilder(Params.END_DATE, value)

    fun build(config: TushareApiConfig): Map<String, String> {
        validate(config)
        return params.mapKeys { it.key.name }.toMap()
    }

    private fun paramBuilder(key: Params, value: String) = apply { params[key] = value }

    private fun validate(config: TushareApiConfig) {
        config.requiredParams.forEach { param ->
            require(params.containsKey(param)) { 
                "Missing required parameter: ${param.name}"
            }
        }
    }
}



