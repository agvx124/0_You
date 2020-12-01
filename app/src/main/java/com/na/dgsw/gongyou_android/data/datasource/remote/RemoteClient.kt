package com.na.dgsw.gongyou_android.data.datasource.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by NA on 2020-11-30
 * skehdgur8591@naver.com
 */

// 포트번호 고정
// 무선랜
// const hostname = "10.80.163.40";
// 유선랜
// const hostname = "10.72.160.18";

object RemoteClient {

    private const val DEFAULT_HOST = "http://10.80.163.40:3000/"
    private const val apiKey = "260d1a7b009640fa88825296073dab03"

    fun createRetrofit(debug: Boolean): Retrofit {
        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(DEFAULT_HOST)
            .client(
                provideOkHttpClient(
                    provideLoggingInterceptor(debug)
                )
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val b = OkHttpClient.Builder()
        b.addInterceptor(interceptor)

        return b.build()
    }

    private fun provideLoggingInterceptor(debug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()

        logging.level = if (debug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE

        return logging
    }
}