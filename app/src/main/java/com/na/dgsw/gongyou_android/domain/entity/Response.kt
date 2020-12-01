package com.na.dgsw.gongyou_android.domain.entity


/**
 * Created by NA on 2020-05-08
 * skehdgur8591@naver.com
 */

data class Response<T>(var status: Int, var message: String, var data: T)