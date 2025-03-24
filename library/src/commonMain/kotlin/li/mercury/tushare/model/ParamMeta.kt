package li.mercury.tushare.model

data class ParamMeta(
    val displayName: String,
    val inputType: InputType,
    val required: Boolean = false,
    val description: String? = null,
    val pattern: Regex? = null
)

enum class InputType {
    String,
}

fun getApiParams(api: TushareApiConfig): List<ParamMeta> {
    return api.availableParams.map { getParamMeta(it, it in api.requiredParams) }
}

fun getParamMeta(apiName: Params, required: Boolean = false): ParamMeta {
    return when (apiName) {
        Params.TS_CODE -> ParamMeta(
            displayName = "股票代码",
            inputType = InputType.String,
            required = required,
            description = "股票代码"
        )

        Params.ANN_DATE -> ParamMeta(
            displayName = "公告日期",
            inputType = InputType.String,
            required = required,
            description = "公告日期"
        )

        Params.START_DATE -> ParamMeta(
            displayName = "开始日期",
            inputType = InputType.String,
            required = required,
            description = "开始日期"
        )

        Params.END_DATE -> ParamMeta(
            displayName = "结束日期",
            inputType = InputType.String,
            required = required,
            description = "结束日期"
        )

        else -> throw IllegalArgumentException("Unknown API: $apiName")
    }
}