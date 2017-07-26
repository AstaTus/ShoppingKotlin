package com.huizetime.shoppingkotlin.network

import com.huizetime.shoppingkotlin.R
import com.huizetime.shoppingkotlin.application.ShoppingApp
import com.huizetime.shoppingkotlin.entity.LoginEntity
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 * Created by chenjunqi on 2017/7/24.
 */
class HttpCore constructor() {

    var mRetrofit: Retrofit


    init {

        var http_client: OkHttpClient = initOkHttpClient()

        val base_url = ShoppingApp.getSingleton().getString(R.string.http_base_address)
        mRetrofit = Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(base_url)
                .client(http_client)
                .build()
    }

    fun initOkHttpClient() : OkHttpClient {

        val http_client = OkHttpClient.Builder()
        // 添加通用的Header
        .addInterceptor(object: Interceptor {

            override fun intercept(chain: Interceptor.Chain): Response {
                val builder = chain.request().newBuilder()
                builder.addHeader("token", "123");
                return chain.proceed(builder.build());
            }
        })
        /*
        这里可以添加一个HttpLoggingInterceptor，因为Retrofit封装好了从Http请求到解析，
        出了bug很难找出来问题，添加HttpLoggingInterceptor拦截器方便调试接口
         */
        .addInterceptor(HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger {
            override fun log(message: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }).setLevel(HttpLoggingInterceptor.Level.BASIC))
                .connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .build()

        return http_client;
    }

    public fun <T> createApi(c: Class<T>): T {
        return mRetrofit.create(c)
    }
}