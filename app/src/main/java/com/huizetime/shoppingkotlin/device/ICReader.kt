package com.huizetime.shoppingkotlin.device

import com.huizetime.shoppingkotlin.bluetooth.BlueDevice_2_0_Imp
import com.huizetime.shoppingkotlin.bluetooth.StandardUUID

/**
 * Created by chenjunqi on 2017/8/2.
 */
class ICReader(device : BlueDevice_2_0_Imp) {

    private var mDevice : BlueDevice_2_0_Imp;

    init {
        mDevice = device
    }

    public fun init(){
        //mDevice.connect(StandardUUID.SERIAL_PORT_UUID, false, )
    }
}