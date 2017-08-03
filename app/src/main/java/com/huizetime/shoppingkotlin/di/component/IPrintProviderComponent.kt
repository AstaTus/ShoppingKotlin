package com.huizetime.shoppingkotlin.di.component

import com.huizetime.shoppingkotlin.di.module.ApplicationContextModule
import com.huizetime.shoppingkotlin.di.module.BluetoothModule
import com.huizetime.shoppingkotlin.provider.PrintProvider
import dagger.Component

/**
 * Created by chenjunqi on 2017/8/3.
 */

@Component(modules = arrayOf(ApplicationContextModule::class, BluetoothModule::class))
interface IPrintProviderComponent {
    fun inject(printProvider: PrintProvider)
}