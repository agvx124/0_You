package com.na.dgsw.gongyou_android.data.repository

import com.na.dgsw.gongyou_android.data.datasource.remote.file.FileDataSource
import com.na.dgsw.gongyou_android.domain.entity.Response
import com.na.dgsw.gongyou_android.domain.entity.file.request.FileRequest
import com.na.dgsw.gongyou_android.domain.entity.file.response.FileResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by NA on 2020-12-02
 * skehdgur8591@naver.com
 */
class FileRepositoryImpl(private val fileDataSource: FileDataSource): FileRepository {
    override fun postUrlUpload(fileRequest: FileRequest): Single<retrofit2.Response<Response<FileResponse>>>
            = fileDataSource.postUrlUpload(fileRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

    override fun getFiles(fileEigenValue: Int): Single<retrofit2.Response<Response<List<String>>>>
            = fileDataSource.getFiles(fileEigenValue).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}