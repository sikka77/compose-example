package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.models.Coin
import com.plcoding.cryptocurrencyappyt.data.models.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Bhavya Sikka on 28/12/22.
 */
interface CoinApiService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<Coin>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId") coinId: String): CoinDetail
}