package com.barryzea.flowsandroid.data.repository

import com.barryzea.flowsandroid.data.Network.ApiService
import com.barryzea.flowsandroid.data.entities.CryptoEntity
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject


/**
 * Project FlowsAndroid
 * Created by Barry Zea H. on 16/7/23.
 * Copyright (c)  All rights reserved.
 **/

class RepositoryImpl @Inject constructor(private val api: ApiService) : Repository{
    override suspend fun fetchCryptoCurrencyPrice(): Flow<Response<CryptoEntity>>{
        return flow {
            while (true){
                emit(api.getApiService().fetchCryptoCurrencyPrice())
                delay(1000)
            }
        }.flowOn(Dispatchers.IO)

    }
}