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

fun getParamMeta(apiName: String, required: Boolean = false): ParamMeta {
    return when (apiName) {
        "ts_code" -> ParamMeta(
            displayName = "股票代码",
            inputType = InputType.String,
            required = required,
            description = "股票代码"
        )

        "ann_date" -> ParamMeta(
            displayName = "公告日期",
            inputType = InputType.String,
            required = required,
            description = "公告日期"
        )

        "start_date" -> ParamMeta(
            displayName = "开始日期",
            inputType = InputType.String,
            required = required,
            description = "开始日期"
        )

        "end_date" -> ParamMeta(
            displayName = "结束日期",
            inputType = InputType.String,
            required = required,
            description = "结束日期"
        )

        else -> throw IllegalArgumentException("Unknown API: $apiName")
    }
}