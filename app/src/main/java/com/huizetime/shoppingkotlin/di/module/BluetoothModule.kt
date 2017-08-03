package com.huizetime.shoppingkotlin.di.module

import android.bluetooth.BluetoothManager
import android.content.Context
import com.huizetime.shoppingkotlin.bluetooth.CoolBluetoothManager
import dagger.Module
import dagger.Provides

/**
 * Created by chenjunqi on 2017/8/3.
 */

@Module
class BluetoothModule() {

    @Provides
    public fun provideContext(context : Context) : CoolBluetoothManager {
        return CoolBluetoothManager(context)
    }
}