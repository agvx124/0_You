package com.na.dgsw.gongyou_android.data.datasource.remote.file

import com.na.dgsw.gongyou_android.data.datasource.remote.api.FileService
import com.na.dgsw.gongyou_android.domain.entity.Response
import com.na.dgsw.gongyou_android.domain.entity.file.request.FileRequest
import com.na.dgsw.gongyou_android.domain.entity.file.response.FileResponse
import io.reactivex.Single


/**
 * Created by NA on 2020-12-02
 * skehdgur8591@naver.com
 */

class FileSourceImpl(private val fileService: FileService): FileDataSource {

    override fun postUrlUpload(fileRequest: FileRequest): Single<retrofit2.Response<Response<FileResponse>>> {
        return fileService.postUrlUpload(fileRequest)
    }

    override fun getFiles(fileEigenValue: Int): Single<retrofit2.Response<Response<List<String>>>> {
        return fileService.getFiles(fileEigenValue)
    }

}