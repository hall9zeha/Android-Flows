package com.barryzea.flowsandroid.data.Network

import com.barryzea.flowsandroid.data.entities.CryptoEntity
import retrofit2.Response
import retrofit2.http.GET


/**
 * Project FlowsAndroid
 * Created by Barry Zea H. on 16/7/23.
 * Copyright (c)  All rights reserved.
 **/

interface ApiClient {

 @GET("prices/BTC-USD/sell/")
 suspend fun fetchCryptoCurrencyPrice(): Response<CryptoEntity>
}