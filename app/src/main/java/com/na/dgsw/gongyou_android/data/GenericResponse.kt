package com.na.dgsw.gongyou_android.data


/**
 * Created by NA on 2020-05-08
 * skehdgur8591@naver.com
 */

data class GenericResponse<T>(var status: Int = 404, var meesage: String = "Not Found", var data: T? = null) {

}