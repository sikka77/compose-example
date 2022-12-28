package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.models.Coin
import com.plcoding.cryptocurrencyappyt.data.models.CoinDetail
import com.plcoding.cryptocurrencyappyt.data.remote.CoinApiService
import com.plcoding.cryptocurrencyappyt.domain.repositories.CoinRepository
import javax.inject.Inject

/**
 * Created by Bhavya Sikka on 28/12/22.
 */
class CoinRepositoryImpl @Inject constructor(
    private val coinApiService: CoinApiService
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return coinApiService.getCoins()
    }

    override suspend fun getCoinDetails(coinId: String): CoinDetail {
        return coinApiService.getCoinDetails(coinId)
    }
}