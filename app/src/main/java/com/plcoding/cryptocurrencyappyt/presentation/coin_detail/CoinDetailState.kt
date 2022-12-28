package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import com.plcoding.cryptocurrencyappyt.data.models.CoinDetail

/**
 * Created by Bhavya Sikka on 28/12/22.
 */
data class CoinDetailState(
    val isLoading: Boolean? = false,
    val data: CoinDetail? = null,
    var error: String? = ""
)