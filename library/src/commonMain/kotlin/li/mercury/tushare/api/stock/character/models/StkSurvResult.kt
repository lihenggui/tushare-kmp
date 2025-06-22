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
 * 机构调研表返回对象类
 */
@Serializable
public data class StkSurvResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    val name: String? = null,
    /** 调研日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("surv_date")
    val survDate: LocalDate? = null,
    /** 机构参与人员 */
    @SerialName("fund_visitors")
    val fundVisitors: String? = null,
    /** 接待地点 */
    @SerialName("rece_place")
    val recePlace: String? = null,
    /** 接待方式 */
    @SerialName("rece_mode")
    val receMode: String? = null,
    /** 接待的公司 */
    @SerialName("rece_org")
    val receOrg: String? = null,
    /** 接待公司类型 */
    @SerialName("org_type")
    val orgType: String? = null,
    /** 上市公司接待人员 */
    @SerialName("comp_rece")
    val compRece: String? = null,
    /** 调研内容 */
    val content: String? = null,
)
