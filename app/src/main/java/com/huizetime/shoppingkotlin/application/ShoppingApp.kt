package com.huizetime.shoppingkotlin.application

import android.app.Application

/**
 * Created by chenjunqi on 2017/7/24.
 */

class ShoppingApp private constructor () : Application() {

    companion object {
        private var sSingleton: ShoppingApp? = null

        public fun getSingleton() : ShoppingApp
        {
            if (sSingleton == null)
                sSingleton = ShoppingApp()

            return sSingleton as ShoppingApp
        }
    }

    public override fun onCreate() {
        super.onCreate()


    }
}