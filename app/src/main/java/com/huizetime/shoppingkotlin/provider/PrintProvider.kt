package com.huizetime.shoppingkotlin.provider

import android.content.Context
import com.huizetime.shoppingkotlin.bluetooth.*
import com.huizetime.shoppingkotlin.bluetooth.search.ISearchCallback
import com.huizetime.shoppingkotlin.device.Printer
import com.huizetime.shoppingkotlin.di.module.ApplicationContextModule
import java.security.KeyException
import javax.inject.Inject

/**
 * Created by chenjunqi on 2017/8/2.
 */

class PrintProvider(context: Context, bluetooth_mgr : CoolBluetoothManager) : BaseProvider(){

    @Inject
    public var mContext: Context

    @Inject
    public var mBluetoothMgr : CoolBluetoothManager

    private var mPrintDevice: BlueDevice_2_0_Imp? = null
    private lateinit var mPrinter: Printer

    private val m20Devices : HashMap<String, BlueDevice_2_0_Imp> = HashMap<String, BlueDevice_2_0_Imp>()
    private val m40Devices : HashMap<String, BlueDevice_4_0_Imp> = HashMap<String, BlueDevice_4_0_Imp>()

    init {
//        DaggerIPrintProviderComponent.builder()(ApplicationContextModule(this)).build()
        //DaggerIPrintProviderComponent
        mContext = context
        mBluetoothMgr = CoolBluetoothManager(mContext)

    }


    override fun cancel() {

        if (mPrintDevice != null){
            mPrintDevice?.disconnect()
        }

    }

    fun search(){
        mBluetoothMgr.search(object: ISearchCallback {

            override fun onStart(){
                m20Devices.clear()
                m40Devices.clear();
            }

            override fun onBL40Searching(device: BlueDevice_4_0_Imp){
                //m40Devices.put(device.mSearchResult.device.address, device);
            }

            override fun onBL20Searching(device: BlueDevice_2_0_Imp){
                m20Devices.put(device.mSearchResult.device.address, device);
            }


            override fun onComplete(){

            }
        })
    }

    public fun connect(address: String, callback: IDeviceCallback){
        var device: BlueDevice_2_0_Imp? = m20Devices.get(address)
        if (device != null){
            mPrinter = Printer(device)
            mPrinter.init(callback)
        }else{
            throw NoSuchFieldException()
        }
    }

    public fun print(message: String){
            mPrinter.pirnt(message.toByteArray())
    }
}