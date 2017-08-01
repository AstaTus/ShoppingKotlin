package com.huizetime.shoppingkotlin.service

import com.huizetime.shoppingkotlin.application.ShoppingApp
import com.huizetime.shoppingkotlin.network.HttpResult
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by chenjunqi on 2017/7/26.
 */
abstract class Service {

    init {
        ShoppingApp.getSingleton().sProcessServicePool.add(this)
    }

    abstract fun cancel();
}
