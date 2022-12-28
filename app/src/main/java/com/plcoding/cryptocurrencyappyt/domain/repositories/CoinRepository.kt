package com.plcoding.cryptocurrencyappyt.domain.repositories

import com.plcoding.cryptocurrencyappyt.data.models.Coin
import com.plcoding.cryptocurrencyappyt.data.models.CoinDetail

/**
 * Created by Bhavya Sikka on 28/12/22.
 */
interface CoinRepository {
    suspend fun getCoins(): List<Coin>

    suspend fun getCoinDetails(coinId: String): CoinDetail
}