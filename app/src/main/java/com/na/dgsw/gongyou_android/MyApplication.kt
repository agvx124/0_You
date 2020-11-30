package com.na.dgsw.gongyou_android

import android.app.Application
import com.na.dgsw.gongyou_android.presentation.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
 * Created by NA on 2020-11-30
 * skehdgur8591@naver.com
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModules)
        }
    }
}