package com.barryzea.flowsandroid.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.barryzea.flowsandroid.data.entities.CryptoEntity
import com.barryzea.flowsandroid.domain.GetCryptoCurrencyPriceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Project FlowsAndroid
 * Created by Barry Zea H. on 16/7/23.
 * Copyright (c)  All rights reserved.
 **/
@HiltViewModel
class MainViewModel @Inject constructor(private val useCase:GetCryptoCurrencyPriceUseCase): ViewModel() {
    private var _response:MutableLiveData<ResponseType> = MutableLiveData()
    val response:LiveData<ResponseType>  = _response

    fun fetchCryptoCurrencyPrice(){
        viewModelScope.launch {
            useCase.fetchCurrencyPrice()
                .catch{_response.value = ResponseType.Error(it.message.toString())}
                .collect{ _response.value = ResponseType.Success(it!!)}

        }
    }
    sealed class ResponseType{
        class Success(val cryptoEntity: CryptoEntity):ResponseType()
        class Error(val error:String):ResponseType()
        object Loading:ResponseType()
    }
}