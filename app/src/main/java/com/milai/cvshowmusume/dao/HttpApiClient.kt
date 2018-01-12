package com.milai.cvshowmusume.dao

import com.milai.cvshowmusume.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Administrator on 2018/1/12.
 *
 * 主要功能：单例模式（object声明）
 */
object HttpApiClient {

    fun retrofit(): HttpRetrofit {
        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            // Log信息拦截器
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            //设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor)
        }
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://meishuguan.domobile.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        //ApiStores::class.java取得对象的 Java 类
        return retrofit.create(HttpRetrofit::class.java)
    }
}