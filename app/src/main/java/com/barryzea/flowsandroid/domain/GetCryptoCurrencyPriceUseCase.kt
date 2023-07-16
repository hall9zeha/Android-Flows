package com.barryzea.flowsandroid.domain

import com.barryzea.flowsandroid.data.entities.CryptoEntity
import com.barryzea.flowsandroid.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


/**
 * Project FlowsAndroid
 * Created by Barry Zea H. on 16/7/23.
 * Copyright (c)  All rights reserved.
 **/

class GetCryptoCurrencyPriceUseCase(private val repository:Repository) {
    suspend fun fetchCurrencyPrice(): Flow<CryptoEntity?> {
        return flow {
              repository.fetchCryptoCurrencyPrice().collect{response->
                  if(response.isSuccessful){
                      emit(response.body())
                  }else{
                      emit(CryptoEntity(null))
                  }
              }
        }

    }
}