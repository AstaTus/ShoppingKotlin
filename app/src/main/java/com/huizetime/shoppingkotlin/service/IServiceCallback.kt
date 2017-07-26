package com.huizetime.shoppingkotlin.service

/**
 * Created by chenjunqi on 2017/7/26.
 */


interface IServiceCallback<T>{

    fun onHandleSuccess(entity : T)

    fun onHandleFailure()

    fun onError()

}