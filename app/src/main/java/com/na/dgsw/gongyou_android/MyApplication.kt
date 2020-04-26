package com.na.dgsw.gongyou_android

import android.app.Application
import com.na.dgsw.gongyou_android.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
 * Created by NA on 2020-04-27
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