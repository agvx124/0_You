package com.na.dgsw.gongyou_android.domain.entity.file.response

import java.io.Serializable


/**
 * Created by NA on 2020-06-03
 * skehdgur8591@naver.com
 */

data class FileResponse(var idx: Int, var fileEigenValue: Int, var senderId: String, var filesUrl: String, var fileExt: String, var fileNumbered: String): Serializable