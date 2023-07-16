package com.barryzea.flowsandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * Project FlowsAndroid
 * Created by Barry Zea H. on 16/7/23.
 * Copyright (c)  All rights reserved.
 **/

@HiltAndroidApp
class MyApp: Application() {
 override fun onCreate() {
  super.onCreate()
 }
}