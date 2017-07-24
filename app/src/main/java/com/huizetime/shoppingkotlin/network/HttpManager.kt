package com.huizetime.shoppingkotlin.network

import com.huizetime.shoppingkotlin.R
import com.huizetime.shoppingkotlin.application.ShoppingApp
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by chenjunqi on 2017/7/24.
 */
class HttpManager private constructor(){

    var mRetrofit : Retrofit? = null

    companion object {
        var sSingleton : HttpManager? = null

        fun getSingleton() : HttpManager
        {
            if (sSingleton == null)
                sSingleton = HttpManager()

            return sSingleton as HttpManager
        }

    }


    public fun init() {

        val base_url = ShoppingApp.getSingleton().getString(R.string.http_base_address)
        mRetrofit = Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url)
                .build()
    }
}