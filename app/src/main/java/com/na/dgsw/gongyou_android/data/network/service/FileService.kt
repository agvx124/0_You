package com.na.dgsw.gongyou_android.data.network.service

import com.na.dgsw.gongyou_android.data.network.request.FileRequest
import com.na.dgsw.gongyou_android.data.network.response.FileResponse
import io.reactivex.Single
import com.na.dgsw.gongyou_android.data.network.Response
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * Created by NA on 2020-06-03
 * skehdgur8591@naver.com
 */

interface FileService {

    @POST("v1/upload/urlUpload")
    fun postUrlUpload(
        @Body fileRequest: FileRequest
    ): Single<retrofit2.Response<Response<FileResponse>>>

}