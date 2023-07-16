package com.barryzea.flowsandroid.ui.adapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

import com.barryzea.flowsandroid.ui.viewModel.MainViewModel.ResponseType


/**
 * Project FlowsAndroid
 * Created by Barry Zea H. on 16/7/23.
 * Copyright (c)  All rights reserved.
 **/

@BindingAdapter("loadResponse")
fun loadResponse(view:TextView, response: ResponseType?){
    response?.let {
        when (response) {
            is ResponseType.Success -> {
                response.cryptoEntity.data?.let {
                    view.text = String.format(
                        "%s %s", response.cryptoEntity.data.amount,
                        response.cryptoEntity.data.currency
                    )
                }
            }

            is ResponseType.Error -> {
                view.text = response.error
            }

            else -> {}
        }
    }
}