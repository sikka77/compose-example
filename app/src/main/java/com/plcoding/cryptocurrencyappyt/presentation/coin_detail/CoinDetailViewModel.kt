package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.commons.Resource
import com.plcoding.cryptocurrencyappyt.domain.usecases.GetCoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Bhavya Sikka on 28/12/22.
 */

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        savedStateHandle.get<String>("coinId")?.let {
            getCoinDetails(it)
        }
    }

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    private fun getCoinDetails(coinId: String) {
        getCoinDetailsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    //_state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "Error occured")
                }
                is Resource.Success -> {
                    _state.value = CoinDetailState(data = result.data)
                }
            }
        }.launchIn(
            viewModelScope
        )
    }

}