package com.na.dgsw.gongyou_android.di

import com.na.dgsw.gongyou_android.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Created by NA on 2020-04-27
 * skehdgur8591@naver.com
 */

val appModule = module {
    viewModel {
        MainViewModel(get())
    }
}

val apiModule = module {
    single {

    }
}

val appModules = listOf(appModule);