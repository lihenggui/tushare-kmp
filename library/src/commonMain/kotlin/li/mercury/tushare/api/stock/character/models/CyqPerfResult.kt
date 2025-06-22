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
package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 每日筹码及胜率返回对象类
 */
@Serializable
public data class CyqPerfResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 历史最低价 */
    @SerialName("his_low")
    val hisLow: Float,
    /** 历史最高价 */
    @SerialName("his_high")
    val hisHigh: Float,
    /** 5分位成本 */
    @SerialName("cost_5pct")
    val cost5pct: Float,
    /** 15分位成本 */
    @SerialName("cost_15pct")
    val cost15pct: Float? = null,
    /** 50分位成本 */
    @SerialName("cost_50pct")
    val cost50pct: Float? = null,
    /** 85分位成本 */
    @SerialName("cost_85pct")
    val cost85pct: Float? = null,
    /** 95分位成本 */
    @SerialName("cost_95pct")
    val cost95pct: Float,
    /** 加权平均成本 */
    @SerialName("weight_avg")
    val weightAvg: Float,
    /** 胜率 */
    @SerialName("winner_rate")
    val winnerRate: Float,
)
