package com.huizetime.shoppingkotlin.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by chenjunqi on 2017/8/3.
 */
@Module
class ApplicationContextModule(context: Context) {
    private var mContext: Context;

    init {
        mContext = context;
    }

    @Provides
    public fun provideContext(context : Context) : Context {
        return mContext
    }
}