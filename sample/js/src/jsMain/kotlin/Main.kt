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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.internal.logging.LogLevel
import li.mercury.tushare.models.TsCode

fun main() {
    console.log("TuShare JS Sample")

    val token = js("process.env.TUSHARE_TOKEN") as? String

    if (token == null) {
        console.error("TUSHARE_TOKEN environment variable must be set.")
        return
    }

    GlobalScope.launch {
        try {
            console.log("Creating TuShare client...")
            val tuShare =
                TuShare(
                    token = token,
                    loggingConfig = LoggingConfig(LogLevel.None),
                )

            console.log("Querying for stock information...")
            val result =
                tuShare.getStockBasic(
                    StockBasicParams(
                        tsCode = TsCode("600519", "SH"), // Kweichow Moutai
                    ),
                )

            if (result.isNotEmpty()) {
                val stock = result.first()
                console.log("Stock found: ${stock.name} (${stock.tsCode})")
                console.log("Industry: ${stock.industry}")
                console.log("Listing Date: ${stock.listDate}")
            } else {
                console.log("No stock data found")
            }

            tuShare.close()
            console.log("Sample completed")
        } catch (e: Exception) {
            console.error("Error: ${e.message}")
        }
    }
}
