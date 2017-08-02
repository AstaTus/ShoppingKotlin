package com.huizetime.shoppingkotlin.provider

/**
 * Created by chenjunqi on 2017/8/2.
 */
interface IProviderStepCallback<T> {
    fun onStep(entity : T)

    fun onComplete()

    fun onFailure()
}