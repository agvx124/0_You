package com.na.dgsw.gongyou_android.presentation.ui.base

import com.na.dgsw.gongyou_android.utils.Utils
import com.na.dgsw.gongyou_android.domain.entity.Response
import io.reactivex.functions.Function

import org.json.JSONObject

import java.util.*


/**
 * Created by NA on 2020-06-04
 * skehdgur8591@naver.com
 */

abstract class BaseClient<V> {

    protected val service: V
        get() = Utils.RETROFIT.create(getService())

    protected abstract fun getService(): Class<V>

    protected fun <T> getResponseObjectsFunction(): Function<retrofit2.Response<Response<T>>, T> {
        return Function { response: retrofit2.Response<Response<T>> -> checkError(response)
            response.body()!!.data
        }
    }

    protected fun getResponseMessageFunction(): Function<retrofit2.Response<Response<Any>>, String> {
        return Function { response: retrofit2.Response<Response<Any>> -> checkError(response)
            response.body()!!.message
        }
    }

    private fun checkError(response: retrofit2.Response<*>) {
        if (!response.isSuccessful) {
            val errorBody = JSONObject(Objects.requireNonNull(response.errorBody())?.string())
            throw Exception(errorBody.getString("message"))
        }
    }
}