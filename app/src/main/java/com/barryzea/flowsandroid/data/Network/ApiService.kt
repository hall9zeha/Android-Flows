package com.barryzea.flowsandroid.data.Network

import com.barryzea.flowsandroid.common.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Project FlowsAndroid
 * Created by Barry Zea H. on 16/7/23.
 * Copyright (c)  All rights reserved.
 **/

@Module
@InstallIn(SingletonComponent::class)
class ApiService @Inject constructor() {

    private val retrofit = Retrofit.Builder()
   .baseUrl(BASE_URL)
   .addConverterFactory(GsonConverterFactory.create())
   .build()

  
  @Provides
  fun getApiService(): ApiClient = retrofit.create(ApiClient::class.java)

}