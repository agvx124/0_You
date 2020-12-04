package com.na.dgsw.gongyou_android.presentation.ui.send

import android.annotation.SuppressLint
import android.app.Application
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseViewModel
import com.na.dgsw.gongyou_android.domain.entity.file.request.FileRequest
import com.na.dgsw.gongyou_android.domain.entity.file.response.FileResponse
import com.na.dgsw.gongyou_android.domain.usecase.FileUseCase
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent


/**
 * Created by NA on 2020-05-26
 * skehdgur8591@naver.com
 */

class SendViewModel(application: Application, private val fileUseCase: FileUseCase): BaseViewModel<FileResponse>(application) {

    val onSuccessEvent = SingleLiveEvent<FileResponse>()
    val cancelBtnClickEvent = SingleLiveEvent<Unit>()
    val sendBtnClickEvent = SingleLiveEvent<Unit>()

    @SuppressLint("CheckResult")
    fun postUrlUpload(request: FileRequest) {
        fileUseCase.postUrlUpload(request).subscribe { response ->
            if (response.isSuccessful) {
                onSuccessEvent.value = response.body()!!.data
            }
        }
    }

    fun onCancelBtnClick() {
        cancelBtnClickEvent.call()
    }

    fun onSendBtnClick() {
        sendBtnClickEvent.call()
    }

    override fun onRetrieveDataSuccess(data: FileResponse) {
        super.onRetrieveDataSuccess(data)

        onSuccessEvent.value = data
    }
}