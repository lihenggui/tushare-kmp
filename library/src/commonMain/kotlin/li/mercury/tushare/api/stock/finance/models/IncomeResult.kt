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
package li.mercury.tushare.api.stock.finance.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 利润表返回对象类
 */
@Serializable
public data class IncomeResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 实际公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("f_ann_date")
    val fAnnDate: LocalDate? = null,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 报告类型 */
    @SerialName("report_type")
    val reportType: ReportType? = null,
    /** 公司类型 */
    @SerialName("comp_type")
    val compType: CompanyType? = null,
    /** 报告期类型 */
    @SerialName("end_type")
    val endType: String? = null,
    /** 基本每股收益 */
    @SerialName("basic_eps")
    val basicEps: Float? = null,
    /** 稀释每股收益 */
    @SerialName("diluted_eps")
    val dilutedEps: Float? = null,
    /** 营业总收入 */
    @SerialName("total_revenue")
    val totalRevenue: Float? = null,
    /** 营业收入 */
    val revenue: Float? = null,
    /** 投资净收益 */
    @SerialName("invest_income")
    val investIncome: Float? = null,
    /** 利润总额 */
    @SerialName("total_profit")
    val totalProfit: Float? = null,
    /** 所得税费用 */
    @SerialName("income_tax")
    val incomeTax: Float? = null,
    /** 净利润（含少数股东损益） */
    @SerialName("n_income")
    val nIncome: Float? = null,
    /** 净利润（不含少数股东损益） */
    @SerialName("n_income_attr_p")
    val nIncomeAttrP: Float? = null,
    /** 少数股东损益 */
    @SerialName("minority_gain")
    val minorityGain: Float? = null,
    /** 息税前利润 */
    val ebit: Float? = null,
    /** 息税折旧摊销前利润 */
    val ebitda: Float? = null,
    /** 研发费用 */
    @SerialName("rd_exp")
    val rdExp: Float? = null,
)
