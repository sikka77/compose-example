package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.commons.Constants
import com.plcoding.cryptocurrencyappyt.data.remote.CoinApiService
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Bhavya Sikka on 28/12/22.
 */


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesCoinApiService(): CoinApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(api: CoinApiService): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}