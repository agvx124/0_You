package com.na.dgsw.gongyou_android.viewmodel

import android.app.Application
import com.na.dgsw.gongyou_android.base.BaseViewModel
import com.na.dgsw.gongyou_android.data.network.client.FileUploadClient
import com.na.dgsw.gongyou_android.data.network.response.FileResponse


/**
 * Created by NA on 2020-05-26
 * skehdgur8591@naver.com
 */

class SendViewModel(application: Application): BaseViewModel<FileResponse>(application) {
    private val fileUploadClient: FileUploadClient = FileUploadClient()



}