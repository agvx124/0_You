package com.na.dgsw.gongyou_android.presentation.di

import com.na.dgsw.gongyou_android.data.datasource.remote.RemoteClient
import com.na.dgsw.gongyou_android.data.datasource.remote.api.FileService
import com.na.dgsw.gongyou_android.data.datasource.remote.file.FileDataSource
import com.na.dgsw.gongyou_android.data.datasource.remote.file.FileSourceImpl
import com.na.dgsw.gongyou_android.data.repository.FileRepository
import com.na.dgsw.gongyou_android.data.repository.FileRepositoryImpl
import com.na.dgsw.gongyou_android.domain.usecase.FileUseCase
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
    viewModel { GetMainViewModel(get(), get()) }
    viewModel { SendMainViewModel(get()) }
    viewModel { SendViewModel(get(), get()) }
    viewModel { SplashViewModel(get()) }
    viewModel { WaitSendViewModel(get()) }
}

val remoteModule = module {
    single { RemoteClient }
}

val dataSourceModule = module {
    single { FileSourceImpl(get()) as FileDataSource }
}

val apiModule = module {
    single { fileAPI }
}

val repositoryModule = module {
    single { FileRepositoryImpl(get()) as FileRepository }
}

val useCaseModule = module {
    single { FileUseCase(get()) }
}

val retrofit = RemoteClient.createRetrofit(true)
private val fileAPI = retrofit.create(FileService::class.java)

val appModules = listOf(
    viewModelModule,
    remoteModule,
    dataSourceModule,
    apiModule,
    repositoryModule,
    useCaseModule
)