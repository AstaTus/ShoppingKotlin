package com.huizetime.shoppingkotlin.provider

import com.huizetime.shoppingkotlin.application.ShoppingApp

/**
 * Created by chenjunqi on 2017/8/2.
 */
abstract class BaseProvider {

    init {
        ShoppingApp.getSingleton().sProcessServicePool.add(this)
    }

    abstract fun cancel();
}