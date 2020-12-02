package com.na.dgsw.gongyou_android.domain.usecase

import com.na.dgsw.gongyou_android.data.repository.FileRepository
import com.na.dgsw.gongyou_android.domain.entity.file.request.FileRequest


/**
 * Created by NA on 2020-12-02
 * skehdgur8591@naver.com
 */
class FileUseCase(private val fileRepository: FileRepository) {
    fun postUrlUpload(fileRequest: FileRequest) {
        fileRepository.postUrlUpload(fileRequest)
    }

    fun getFiles(fileEigenValue: Int) {
        fileRepository.getFiles(fileEigenValue)
    }
}