package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.commons.Resource
import com.plcoding.cryptocurrencyappyt.domain.usecases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Bhavya Sikka on 28/12/22.
 */

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    init {
        getCoins()
    }

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value =
                        CoinListState(isLoading = false, error = result.message ?: "Error occured.")
                }
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

}