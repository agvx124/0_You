package com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseViewModel
import com.na.dgsw.gongyou_android.domain.usecase.FileUseCase
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent


/**
 * Created by NA on 2020-06-25
 * skehdgur8591@naver.com
 */
class GetMainViewModel(application: Application, private val fileUseCase: FileUseCase): BaseViewModel<List<String>>(application) {

    val onSuccessEvent = SingleLiveEvent<List<String>>()

    val onQrCodeScannerEvent = SingleLiveEvent<Unit>()
    val onDownloadEvent = SingleLiveEvent<Unit>()

    fun qrCodeScannerBtnClick() {
        onQrCodeScannerEvent.call()
    }

    fun downloadBtnClick() {
        onDownloadEvent.call()
    }

    @SuppressLint("CheckResult")
    fun getFiles(fileEigenValue: Int) {
        fileUseCase.getFiles(fileEigenValue).subscribe { response ->
            if (response.isSuccessful) {
                onSuccessEvent.value = response.body()!!.data
            }
        }
    }

    override fun onRetrieveDataSuccess(data: List<String>) {
        super.onRetrieveDataSuccess(data)

        onSuccessEvent.value = data
    }

}