package com.huizetime.shoppingkotlin.application

import android.app.Application
import com.clj.fastble.BleManager
import com.huizetime.shoppingkotlin.network.HttpCore
import com.huizetime.shoppingkotlin.service.ProcessServicePool
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.Logger.addLogAdapter



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

    //all of global var
    val sHttpCore : HttpCore by lazy { HttpCore() }
    val sProcessServicePool : ProcessServicePool by lazy { ProcessServicePool() }

    public override fun onCreate() {
        super.onCreate()

        initLogger()

    }

    public override fun onDes

    private fun initGlobals(){


    }
    private fun initLogger(){
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}