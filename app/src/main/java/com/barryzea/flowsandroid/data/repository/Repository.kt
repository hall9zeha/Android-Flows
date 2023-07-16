package com.barryzea.flowsandroid.data.repository

import com.barryzea.flowsandroid.data.entities.CryptoEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


/**
 * Project FlowsAndroid
 * Created by Barry Zea H. on 16/7/23.
 * Copyright (c)  All rights reserved.
 **/

interface Repository {
    suspend fun fetchCryptoCurrencyPrice(): Flow<Response<CryptoEntity>>
}