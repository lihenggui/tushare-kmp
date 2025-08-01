/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *
 * Copyright (C) 2025 Mercury Li
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 市场交易统计返回结果
 */
@Serializable
public data class DailyInfoResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 市场代码 */
    @SerialName("ts_code")
    val tsCode: String,
    /** 市场名称 */
    @SerialName("ts_name")
    val tsName: String,
    /** 挂牌数 */
    @SerialName("com_count")
    val comCount: Int,
    /** 总股本（亿股） */
    @SerialName("total_share")
    val totalShare: Double? = null,
    /** 流通股本（亿股） */
    @SerialName("float_share")
    val floatShare: Double? = null,
    /** 总市值（亿元） */
    @SerialName("total_mv")
    val totalMv: Double? = null,
    /** 流通市值（亿元） */
    @SerialName("float_mv")
    val floatMv: Double? = null,
    /** 交易金额（亿元） */
    val amount: Double,
    /** 成交量（亿股） */
    val vol: Double? = null,
    /** 成交笔数（万笔） */
    @SerialName("trans_count")
    val transCount: Int? = null,
    /** 平均市盈率 */
    val pe: Double? = null,
    /** 换手率（%） */
    val tr: Double? = null,
    /** 交易所代码 */
    val exchange: Exchange,
)
