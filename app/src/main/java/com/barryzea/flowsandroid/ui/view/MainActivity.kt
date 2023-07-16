package com.barryzea.flowsandroid.ui.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.barryzea.flowsandroid.R
import com.barryzea.flowsandroid.databinding.ActivityMainBinding
import com.barryzea.flowsandroid.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by viewModels()
    private lateinit  var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setContentView(bind.root)
        setUpDataBinding()
        setUpViewModel()
        viewModel.fetchCryptoCurrencyPrice()
    }
    private fun setUpDataBinding(){
        bind.lifecycleOwner = this
        bind.viewModel= viewModel
    }
    private fun setUpViewModel() {

    }
}