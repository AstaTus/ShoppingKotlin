package com.huizetime.shoppingkotlin.service

import com.huizetime.shoppingkotlin.application.ShoppingApp
import com.huizetime.shoppingkotlin.entity.LoginEntity
import com.huizetime.shoppingkotlin.network.HttpObsersver
import com.huizetime.shoppingkotlin.network.HttpResult
import com.huizetime.shoppingkotlin.network.NWLoginApi
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription

/**
 * Created by chenjunqi on 2017/7/26.
 */


public class LoginService<T> : Service<T>() {

    fun login(user_name : String, password : String, callback : IServiceCallback<T>){
        var login_api : NWLoginApi = ShoppingApp.getSingleton().sHttpCore.createApi(NWLoginApi::class.java)

        var observer : HttpObsersver<T> = HttpObsersver<T>(callback)

        mObservable = login_api.login<T>(user_name, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        mObservable?.subscribe(observer)

    }
}