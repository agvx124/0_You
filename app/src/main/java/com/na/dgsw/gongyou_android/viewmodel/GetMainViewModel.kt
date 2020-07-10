package com.na.dgsw.gongyou_android.viewmodel

import android.app.Application
import com.na.dgsw.gongyou_android.base.BaseViewModel
import com.na.dgsw.gongyou_android.data.network.client.FileUploadClient
import com.na.dgsw.gongyou_android.data.network.response.FileResponse
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent


/**
 * Created by NA on 2020-06-25
 * skehdgur8591@naver.com
 */
class GetMainViewModel(application: Application): BaseViewModel<List<String>>(application) {

    private val fileUploadClient: FileUploadClient = FileUploadClient()

    val onSuccessEvent = SingleLiveEvent<List<String>>()

    val onQrCodeScannerEvent = SingleLiveEvent<Unit>()
    val onDownloadEvent = SingleLiveEvent<Unit>()

    fun qrCodeScannerBtnClick() {
        onQrCodeScannerEvent.call()
    }

    fun downloadBtnClick() {
        onDownloadEvent.call()
    }

    fun getFiles(fileEigenValue: Int) {
        addDisposable(fileUploadClient.getFiles(fileEigenValue), dataObserver)
    }

    override fun onRetrieveDataSuccess(data: List<String>) {
        super.onRetrieveDataSuccess(data)

        onSuccessEvent.value = data
    }

}