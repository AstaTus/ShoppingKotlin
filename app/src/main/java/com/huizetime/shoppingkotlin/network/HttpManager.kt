package com.huizetime.shoppingkotlin.network

import com.huizetime.shoppingkotlin.R
import com.huizetime.shoppingkotlin.application.ShoppingApp
import com.huizetime.shoppingkotlin.entity.LoginEntity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import android.widget.Toast
import android.icu.util.ULocale.getCountry
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jdk.nashorn.internal.objects.NativeFunction.call
import org.reactivestreams.Subscriber


/**
 * Created by chenjunqi on 2017/7/24.
 */
class HttpManager private constructor(){

    var mRetrofit : Retrofit

    companion object {
        private val sSingleton : HttpManager by lazy {
            HttpManager()
        }
    }


    init{
        val base_url = ShoppingApp.getSingleton().getString(R.string.http_base_address)
        mRetrofit = Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url)
                .build()
    }

    public fun login(user_name : String, password : String, observer : Observer<HttpResult<LoginEntity>>){
        var login_service : LoginService = mRetrofit.create(LoginService::class.java)
        var observable : Observable<HttpResult<LoginEntity>> = login_service.login(user_name, password)
        toSubscribe<HttpResult<LoginEntity>>(observable, observer)

    }

    private fun <T> toSubscribe(observable: Observable<T>, observer: Observer<T>) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}