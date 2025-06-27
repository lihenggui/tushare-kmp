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
package li.mercury.tushare.sample.jvm

import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.models.TsCode

suspend fun singleStockQuery(
    tuShare: TuShare,
    sampleStockCode: String,
    sampleExchange: String,
) {
    println("\n📊 Querying single stock (Kweichow Moutai)...")
    val result =
        tuShare.getStockBasic(
            StockBasicParams(
                tsCode = TsCode(sampleStockCode, sampleExchange),
            ),
        )

    if (result.isNotEmpty()) {
        val stock = result.first()
        println("✅ Query successful!")
        println("  Code: ${stock.tsCode}")
        println("  Name: ${stock.name}")
        println("  Industry: ${stock.industry}")
        println("  List Date: ${stock.listDate}")
        println("  Market: ${stock.market}")
    } else {
        println("❌ No data found")
    }
}

suspend fun multipleStocksQuery(tuShare: TuShare) {
    println("\n📊 Querying multiple stocks...")
    // You can customize this query with additional parameters
    val result = tuShare.getStockBasic(StockBasicParams())

    if (result.isNotEmpty()) {
        println("✅ Query successful! Found ${result.size} stocks")
        println("\nFirst 5 stocks:")
        result.take(5).forEachIndexed { index, stock ->
            println("\n[$index] Stock:")
            println("  Code: ${stock.tsCode}")
            println("  Name: ${stock.name}")
            println("  Industry: ${stock.industry}")
        }
    } else {
        println("❌ No data found")
    }
}
