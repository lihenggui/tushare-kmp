package li.mercury.tushare.api.stock.character

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.character.models.BrokerRecommendParams
import li.mercury.tushare.api.stock.character.models.BrokerRecommendResult
import li.mercury.tushare.api.stock.character.models.CcassHoldDetailParams
import li.mercury.tushare.api.stock.character.models.CcassHoldDetailResult
import li.mercury.tushare.api.stock.character.models.CcassHoldParams
import li.mercury.tushare.api.stock.character.models.CcassHoldResult
import li.mercury.tushare.api.stock.character.models.CyqChipsParams
import li.mercury.tushare.api.stock.character.models.CyqChipsResult
import li.mercury.tushare.api.stock.character.models.CyqPerfParams
import li.mercury.tushare.api.stock.character.models.CyqPerfResult
import li.mercury.tushare.api.stock.character.models.HkHoldParams
import li.mercury.tushare.api.stock.character.models.HkHoldResult
import li.mercury.tushare.api.stock.character.models.ReportRcParams
import li.mercury.tushare.api.stock.character.models.ReportRcResult
import li.mercury.tushare.api.stock.character.models.StkAuctionCParams
import li.mercury.tushare.api.stock.character.models.StkAuctionCResult
import li.mercury.tushare.api.stock.character.models.StkAuctionOParams
import li.mercury.tushare.api.stock.character.models.StkAuctionOResult
import li.mercury.tushare.api.stock.character.models.StkFactorParams
import li.mercury.tushare.api.stock.character.models.StkFactorProParams
import li.mercury.tushare.api.stock.character.models.StkFactorProResult
import li.mercury.tushare.api.stock.character.models.StkFactorResult
import li.mercury.tushare.api.stock.character.models.StkNineturnParams
import li.mercury.tushare.api.stock.character.models.StkNineturnResult
import li.mercury.tushare.api.stock.character.models.StkSurvParams
import li.mercury.tushare.api.stock.character.models.StkSurvResult

/**
 * 股票相关API的存储库接口
 */
interface StockCharacterApiInterface {
    /**
     * 获取卖方盈利预测数据
     */
    fun getReportRc(params: ReportRcParams): Flow<List<ReportRcResult>>

    /**
     * 获取每日筹码及胜率数据
     */
    fun getCyqPerf(params: CyqPerfParams): Flow<List<CyqPerfResult>>

    /**
     * 获取每日筹码分布数据
     */
    fun getCyqChips(params: CyqChipsParams): Flow<List<CyqChipsResult>>

    /**
     * 获取股票技术因子数据
     */
    fun getStkFactor(params: StkFactorParams): Flow<List<StkFactorResult>>

    /**
     * 获取股票技术面因子（专业版）
     */
    fun getStkFactorPro(params: StkFactorProParams): Flow<List<StkFactorProResult>>

    /**
     * 获取中央结算系统持股汇总数据
     */
    fun getCcassHold(params: CcassHoldParams): Flow<List<CcassHoldResult>>

    /**
     * 获取中央结算系统持股明细数据
     */
    fun getCcassHoldDetail(params: CcassHoldDetailParams): Flow<List<CcassHoldDetailResult>>

    /**
     * 获取沪深港股通持股明细
     */
    fun getHkHold(params: HkHoldParams): Flow<List<HkHoldResult>>

    /**
     * 获取股票开盘集合竞价数据
     */
    fun getStkAuctionO(params: StkAuctionOParams): Flow<List<StkAuctionOResult>>

    /**
     * 获取股票收盘集合竞价数据
     */
    fun getStkAuctionC(params: StkAuctionCParams): Flow<List<StkAuctionCResult>>

    /**
     * 获取神奇九转指标数据
     */
    fun getStkNineturn(params: StkNineturnParams): Flow<List<StkNineturnResult>>

    /**
     * 获取机构调研表数据
     */
    fun getStkSurv(params: StkSurvParams): Flow<List<StkSurvResult>>

    /**
     * 获取券商每月荐股数据
     */
    fun getBrokerRecommend(params: BrokerRecommendParams): Flow<List<BrokerRecommendResult>>
}
