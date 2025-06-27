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
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.internal.logging.LogLevel
import li.mercury.tushare.models.TsCode

suspend fun main() {
    val token = js("process.env.TUSHARE_TOKEN").unsafeCast<String>()
    val tuShare =
        TuShare(
            token = token,
            loggingConfig = LoggingConfig(LogLevel.None),
        )

    println("\n> Getting Stock basic data...")
    val stockBasic = tuShare.getStockBasic(StockBasicParams(tsCode = TsCode("000001", "SZ")))
    println("Stock basic data: $stockBasic")

    println("\n> Getting Index basic data...")
    val indexBasic = tuShare.getIndexBasic(IndexBasicParams(tsCode = TsCode("000001", "SH")))
    println("Index basic data: $indexBasic")
}
