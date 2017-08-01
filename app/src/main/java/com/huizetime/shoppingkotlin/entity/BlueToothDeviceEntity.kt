package com.huizetime.shoppingkotlin.entity

/**
 * Created by chenjunqi on 2017/7/31.
 */


class BlueToothDeviceEntity(name: String, address: String){
    private var name : String = name;
    private  var address : String = address;


    fun getName(): String{
        return name
    }

    fun getAddress(): String{
        return address
    }

    fun setName(name: String){
        this.name = name
    }

    fun setAddress(address : String){
        this.address = address
    }

}