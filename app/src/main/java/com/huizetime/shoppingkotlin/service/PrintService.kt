package com.huizetime.shoppingkotlin.service

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattService
import com.clj.fastble.BleManager
import com.clj.fastble.conn.BleGattCallback
import com.clj.fastble.data.ScanResult
import com.clj.fastble.exception.BleException
import com.clj.fastble.scan.ListScanCallback
import com.huizetime.shoppingkotlin.application.ShoppingApp
import com.huizetime.shoppingkotlin.entity.BlueToothDeviceEntity
import java.security.InvalidParameterException

/**
 * Created by chenjunqi on 2017/7/31.
 */
class PrintService : Service() {

    private val UUID_SERVICE = "00000101-0000-1000-8000-00805f9b34FB"

    private val TIME_OUT: Long = 5000


    private val mScanResults : HashMap<String, ScanResult>

    private val mBleManager : BleManager

    class Command(){
        companion object {
            val RESET = arrayOf({0x1b; 0x40})
            val PRINT = arrayOf({0x1b; 0x4d; 0x00})
        }
    }

    init {
        mBleManager = BleManager(ShoppingApp.getSingleton())
        mScanResults = HashMap<String, ScanResult>()
    }

    fun print(message : String){
        //mBleManager.writeDevice(UUID_SERVICE, )
    }

    fun scan(callback : IServiceStepCallback<BlueToothDeviceEntity>){

        mScanResults.clear()
        mBleManager.scanDevice(object : ListScanCallback(TIME_OUT) {
            override fun onScanning(result: ScanResult) {

                mScanResults.put(result.device.address, result)
                val entity = BlueToothDeviceEntity(result.device.name, result.device.address)
                callback.onStep(entity)
            }

            override fun onScanComplete(results: Array<ScanResult>) {
                callback.onComplete()
            }
        })
    }

    fun cancelScan(){
        mBleManager.cancelScan();
    }

    fun disconnect(){

    }

    override fun cancel(){

    }

}