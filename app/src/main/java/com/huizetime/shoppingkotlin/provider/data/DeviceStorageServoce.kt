package com.huizetime.shoppingkotlin.provider.data

import android.content.Intent
import android.os.IBinder
import com.huizetime.shoppingkotlin.database.model.DeviceModel
import com.huizetime.shoppingkotlin.entity.DeviceEntity
import com.huizetime.shoppingkotlin.provider.BaseProvider
import com.huizetime.shoppingkotlin.provider.IProviderCallback

/**
 * Created by chenjunqi on 2017/8/7.
 */
class DeviceStorageProvider: BaseProvider() {


    fun addDevice(address:String, name:String, type: Int, type_name: String, number: String, pin_code: String, callback: IProviderCallback){

        val device = DeviceEntity()
        device.address = address
        device.name = name
        device.type = type
        device.typeName = type_name
        device.number = number
        device.pinCode = pin_code

        DeviceModel.insert(device, callback);
    }

    fun removeDevice(address: String, callback: IProviderCallback){
        DeviceModel.deleteByAddress(address, callback);
    }

    fun getDevices(): List<DeviceEntity>{
        return DeviceModel.findAll()

    }


    override fun cancel() {
        DeviceModel.cancel()
    }
}