package com.huizetime.shoppingkotlin.provider

import com.huizetime.shoppingkotlin.application.ShoppingApp
import com.huizetime.shoppingkotlin.network.HttpObsersver
import com.huizetime.shoppingkotlin.network.HttpResult
import com.huizetime.shoppingkotlin.network.NWLoginApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by chenjunqi on 2017/8/2.
 */
class LoginProvider<T> : BaseProvider() {

    internal var mObservable : Observable<HttpResult<T>>? = null

    fun login(user_name : String, password : String, callback : IProviderEntityCallback<T>){
        var login_api : NWLoginApi = ShoppingApp.getSingleton().sHttpCore.createApi(NWLoginApi::class.java)

        var observer : HttpObsersver<T> = HttpObsersver<T>(callback)

        mObservable = login_api.login<T>(user_name, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        mObservable?.subscribe(observer)

    }

    override fun cancel() {
        mObservable?.unsubscribeOn(Schedulers.io())
    }
}