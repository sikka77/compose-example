package com.plcoding.cryptocurrencyappyt.domain.usecases

import com.plcoding.cryptocurrencyappyt.commons.Resource
import com.plcoding.cryptocurrencyappyt.data.models.CoinDetail
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
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetails = coinRepository.getCoinDetails(coinId)
            emit(Resource.Success(coinDetails))
        } catch (e: java.lang.Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error encountered"))
        }
    }
}