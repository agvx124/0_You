package com.na.dgsw.gongyou_android.presentation.di

import com.na.dgsw.gongyou_android.presentation.ui.getfile.GetFileViewModel
import com.na.dgsw.gongyou_android.presentation.ui.login.LoginViewModel
import com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel.GetMainViewModel
import com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel.MainViewModel
import com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel.SendMainViewModel
import com.na.dgsw.gongyou_android.presentation.ui.send.SendViewModel
import com.na.dgsw.gongyou_android.presentation.ui.splash.SplashViewModel
import com.na.dgsw.gongyou_android.presentation.ui.waitsend.WaitSendViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Created by NA on 2020-11-30
 * skehdgur8591@naver.com
 */
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { GetFileViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { GetMainViewModel(get()) }
    viewModel { SendMainViewModel(get()) }
    viewModel { SendViewModel(get()) }
    viewModel { SplashViewModel(get()) }
    viewModel { WaitSendViewModel(get()) }
}

//val remoteModule = module {
//    single { RemoteClient }
//}
//
//val dataSourceModule = module {
//    single { NiceOpenSourceImpl(get()) as NiceOpenDataSource }
//}
//
//val apiModule = module {
//    single { mealAPI }
//}
//
//val repositoryModule = module {
//    single { MealRepositoryImpl(get()) as MealRepository }
//}
//
//val useCaseModule = module {
//    single { MealUseCase(get()) }
//}
//
//val retrofit = RemoteClient.createRetrofit(true)
//private val mealAPI = retrofit.create(NiceOpenAPI::class.java)

val appModules = listOf(
    viewModelModule
)