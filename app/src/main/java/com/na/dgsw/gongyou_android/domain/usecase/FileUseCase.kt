package com.na.dgsw.gongyou_android.domain.usecase

import com.na.dgsw.gongyou_android.data.repository.FileRepository
import com.na.dgsw.gongyou_android.domain.entity.Response
import com.na.dgsw.gongyou_android.domain.entity.file.request.FileRequest
import com.na.dgsw.gongyou_android.domain.entity.file.response.FileResponse
import io.reactivex.Single


/**
 * Created by NA on 2020-12-02
 * skehdgur8591@naver.com
 */
class FileUseCase(private val fileRepository: FileRepository) {
    fun postUrlUpload(fileRequest: FileRequest): Single<retrofit2.Response<Response<FileResponse>>> {
        return fileRepository.postUrlUpload(fileRequest)
    }

    fun getFiles(fileEigenValue: Int): Single<retrofit2.Response<Response<List<String>>>> {
        return fileRepository.getFiles(fileEigenValue)
    }
}