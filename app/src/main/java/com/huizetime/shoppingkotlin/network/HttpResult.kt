package com.huizetime.shoppingkotlin.network

/**
 * Created by chenjunqi on 2017/7/25.
 */

public class HttpResult<T>{
    var error : Int = 0
    var message : String = ""
    var time : Long = 0
    var data : T? = null
    var encrypt : Boolean = false
}