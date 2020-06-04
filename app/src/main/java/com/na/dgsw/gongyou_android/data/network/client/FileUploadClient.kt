package com.na.dgsw.gongyou_android.data.network.client

import com.na.dgsw.gongyou_android.Utils
import com.na.dgsw.gongyou_android.base.BaseClient
import com.na.dgsw.gongyou_android.data.network.request.FileRequest
import com.na.dgsw.gongyou_android.data.network.response.FileResponse
import com.na.dgsw.gongyou_android.data.network.service.FileService
import io.reactivex.Single


/**
 * Created by NA on 2020-06-02
 * skehdgur8591@naver.com
 */

class FileUploadClient: BaseClient<FileService>() {

    override fun getService(): Class<FileService> {
        return FileService::class.java
    }

    fun postUrlUpload(fileRequest: FileRequest): Single<FileResponse> {
        return service.postUrlUpload(fileRequest).map(getResponseObjectsFunction())
    }

}