package com.barryzea.flowsandroid.di

import com.barryzea.flowsandroid.data.Network.ApiService
import com.barryzea.flowsandroid.data.repository.Repository
import com.barryzea.flowsandroid.data.repository.RepositoryImpl
import com.barryzea.flowsandroid.domain.GetCryptoCurrencyPriceUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Project FlowsAndroid
 * Created by Barry Zea H. on 16/7/23.
 * Copyright (c)  All rights reserved.
 **/

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

  @Singleton
  @Provides
  fun useCaseProvider(repository: RepositoryImpl):GetCryptoCurrencyPriceUseCase= GetCryptoCurrencyPriceUseCase(repository)
}