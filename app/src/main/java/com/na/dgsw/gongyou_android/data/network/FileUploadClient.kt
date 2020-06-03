package com.na.dgsw.gongyou_android.data.network

import com.na.dgsw.gongyou_android.Utils
import com.na.dgsw.gongyou_android.data.network.request.FileRequest
import com.na.dgsw.gongyou_android.data.network.response.FileResponse
import com.na.dgsw.gongyou_android.data.network.service.FileService
import io.reactivex.Single


/**
 * Created by NA on 2020-06-02
 * skehdgur8591@naver.com
 */

abstract class FileUploadClient: NetworkClient() {
    abstract var fileService: FileService

    init {
        fileService = Utils.RETROFIT.create(fileService::class.java)
    }

    fun postUrlUpload(fileRequest: FileRequest): Single<FileResponse> {
        return fileService.postUrlUpload(fileRequest).map(getResponseObjectsFunction())
    }
}