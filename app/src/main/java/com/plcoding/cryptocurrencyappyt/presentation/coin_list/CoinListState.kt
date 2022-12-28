package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import com.plcoding.cryptocurrencyappyt.data.models.Coin

/**
 * Created by Bhavya Sikka on 28/12/22.
 */
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin>? = emptyList(),
    val error: String = ""
)
