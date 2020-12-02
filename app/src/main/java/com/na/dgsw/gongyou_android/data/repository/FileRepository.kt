package com.na.dgsw.gongyou_android.data.repository

import com.na.dgsw.gongyou_android.domain.entity.Response
import com.na.dgsw.gongyou_android.domain.entity.file.request.FileRequest
import com.na.dgsw.gongyou_android.domain.entity.file.response.FileResponse
import io.reactivex.Single


/**
 * Created by NA on 2020-12-02
 * skehdgur8591@naver.com
 */
interface FileRepository {
    fun postUrlUpload(fileRequest: FileRequest): Single<retrofit2.Response<Response<FileResponse>>>

    fun getFiles(fileEigenValue: Int): Single<retrofit2.Response<Response<List<String>>>>
}