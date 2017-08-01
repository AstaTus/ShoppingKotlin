package com.huizetime.shoppingkotlin.service

/**
 * Created by chenjunqi on 2017/7/31.
 */
interface IServiceStepCallback<T> {

    fun onStep(entity : T)

    fun onComplete()

    fun onHandleFailure()

    fun onError()
}