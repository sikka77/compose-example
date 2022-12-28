package com.plcoding.cryptocurrencyappyt.domain.usecases

import com.plcoding.cryptocurrencyappyt.commons.Resource
import com.plcoding.cryptocurrencyappyt.data.models.Coin
import com.plcoding.cryptocurrencyappyt.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Bhavya Sikka on 28/12/22.
 */
class GetCoinDetailsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins()
            emit(Resource.Success(coins))
        } catch (e: java.lang.Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error encountered"))
        }
    }
}