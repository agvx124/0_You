package com.na.dgsw.gongyou_android.data.network.client

import com.na.dgsw.gongyou_android.presentation.ui.base.BaseClient
import com.na.dgsw.gongyou_android.domain.entity.file.request.FileRequest
import com.na.dgsw.gongyou_android.domain.entity.file.response.FileResponse
import com.na.dgsw.gongyou_android.data.datasource.remote.api.FileService
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

    fun getFiles(fileEigenValue: Int): Single<List<String>> {
        return service.getFiles(fileEigenValue).map(getResponseObjectsFunction())
    }

}