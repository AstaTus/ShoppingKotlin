package com.huizetime.shoppingkotlin.service

import com.huizetime.shoppingkotlin.application.ShoppingApp
import com.huizetime.shoppingkotlin.network.HttpResult
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by chenjunqi on 2017/7/26.
 */
abstract class Service<T> {

    init {
        ShoppingApp.getSingleton().sProcessServicePool.add(this)
    }

    internal var mObservable : Observable<HttpResult<T>>? = null

    internal fun cancel() {
        mObservable?.unsubscribeOn(Schedulers.io())
    }
}
