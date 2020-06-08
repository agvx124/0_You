package com.na.dgsw.gongyou_android.viewmodel

import android.app.Application
import com.na.dgsw.gongyou_android.base.BaseViewModel
import com.na.dgsw.gongyou_android.data.network.client.FileUploadClient
import com.na.dgsw.gongyou_android.data.network.request.FileRequest
import com.na.dgsw.gongyou_android.data.network.response.FileResponse
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent


/**
 * Created by NA on 2020-05-26
 * skehdgur8591@naver.com
 */

class SendViewModel(application: Application): BaseViewModel<FileResponse>(application) {
    private val fileUploadClient: FileUploadClient = FileUploadClient()

    val onSuccessEvent = SingleLiveEvent<String>()

    fun postUrlUpload(request: FileRequest) {
        addDisposable(fileUploadClient.postUrlUpload(request), dataObserver)
    }

}