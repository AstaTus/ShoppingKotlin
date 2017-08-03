package com.huizetime.shoppingkotlin.provider;

/**
 * Created by chenjunqi on 2017/8/2.
 */

interface IProviderCallback<T> {

    fun onHandleSuccess(entity : T)

    fun onHandleFailure()

    fun onError()
}
