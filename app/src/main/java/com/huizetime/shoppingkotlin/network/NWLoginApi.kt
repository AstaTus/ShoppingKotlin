package com.huizetime.shoppingkotlin.network

import com.huizetime.shoppingkotlin.entity.LoginEntity
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query



/**
 * Created by chenjunqi on 2017/7/24.
 */
public interface NWLoginApi {
    @POST("coa/app/login.shtml")
    fun <T> login(@Field("userName") user_name : String, @Field("password") password : String) : Observable<HttpResult<T>>
}
