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
package li.mercury.tushare.api.stock.basic.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 上市公司基本信息返回对象类
 */
@Serializable
public data class StockCompanyResult(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公司全称 */
    @SerialName("com_name")
    val comName: String,
    /** 统一社会信用代码 */
    @SerialName("com_id")
    val comId: String,
    /** 交易所代码 */
    val exchange: Exchange,
    /** 法人代表 */
    val chairman: String,
    /** 总经理 */
    val manager: String,
    /** 董秘 */
    val secretary: String,
    /** 注册资本（万元） */
    @SerialName("reg_capital")
    val regCapital: Float,
    /** 注册日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("setup_date")
    val setupDate: LocalDate,
    /** 所在省份 */
    val province: String,
    /** 所在城市 */
    val city: String,
    /** 公司介绍 */
    val introduction: String? = null,
    /** 公司主页 */
    val website: String,
    /** 电子邮件 */
    val email: String,
    /** 办公室 */
    val office: String? = null,
    /** 员工人数 */
    val employees: Int,
    /** 主要业务及产品 */
    @SerialName("main_business")
    val mainBusiness: String? = null,
    /** 经营范围 */
    @SerialName("business_scope")
    val businessScope: String? = null,
)
