package com.plcoding.cryptocurrencyappyt.domain.usecases

import com.plcoding.cryptocurrencyappyt.commons.Resource
import com.plcoding.cryptocurrencyappyt.data.models.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Bhavya Sikka on 28/12/22.
 */
class GetCoinDetailsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetails = coinRepository.getCoinDetails(coinId)
            emit(Resource.Success<CoinDetail>(coinDetails))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Error encountered"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Error encountered"))
        }
    }
}