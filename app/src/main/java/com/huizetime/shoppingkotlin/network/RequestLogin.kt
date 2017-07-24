package com.huizetime.shoppingkotlin.network

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by chenjunqi on 2017/7/24.
 */
public interface RequestLogin{
    @Headers("apikey:81bf9da930c7f9825a3c3383f1d8d766")
    @GET("word/word")
    Call<News> getNews(@Query("num") String num,@Query("page")String page);
}