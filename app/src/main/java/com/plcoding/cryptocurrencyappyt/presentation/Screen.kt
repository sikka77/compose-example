package com.plcoding.cryptocurrencyappyt.presentation

/**
 * Created by Bhavya Sikka on 28/12/22.
 */
sealed class Screen(val route: String) {

    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailsScreen: Screen("coin_details_screen")
}