package com.huizetime.shoppingkotlin.provider;

/**
 * Created by chenjunqi on 2017/8/2.
 */

interface IProviderCallback {

    fun onHandleSuccess()

    fun onHandleFailure()

    fun onError()
}
