package com.huizetime.shoppingkotlin.device;

import com.huizetime.shoppingkotlin.bluetooth.BlueDevice_2_0_Imp
import com.huizetime.shoppingkotlin.bluetooth.IDeviceCallback
import com.huizetime.shoppingkotlin.bluetooth.StandardUUID

/**
 * Created by chenjunqi on 2017/8/2.
 */

public class Printer(device: BlueDevice_2_0_Imp) {
    companion object {

        //格式
        public val COMMON_RESET = byteArrayOf(0x1b, 0x40)                             // 复位打印机
        public val COMMON_STANDARD_ASCII_PRINT = byteArrayOf(0x1b, 0x4d, 0x00)     // 标准ASCII字体
        public val COMMON_COMPRESS_ASCII_PRINT = byteArrayOf(0x1b, 0x4d, 0x01)     // 压缩ASCII字体
        public val COMMON_NORMAL_TEXT_SIZE = byteArrayOf(0x1d, 0x21, 0x00)         // 字体不放大

        public val COMMON_DOUBLE_WIDTH_HEIGHT = byteArrayOf(0x1d, 0x21, 0x11)      // 宽高加倍
        public val COMMON_BOLD_MODE_OFF = byteArrayOf(0x1d, 0x21, 0x00)             // 取消加粗模式
        public val COMMON_BOLD_MODE_ON = byteArrayOf(0x1b, 0x45, 0x01)              // 选择加粗模式
        public val COMMON_REVERSAL_OFF = byteArrayOf(0x1b, 0x7b, 0x00)              // 取消倒置打印
        public val COMMON_REVERSAL_ON = byteArrayOf(0x1b, 0x7b, 0x01)               // 选择倒置打印
        public val COMMON_BLACK_WHITE_OFF = byteArrayOf(0x1d, 0x42, 0x00)          // 取消黑白反显
        public val COMMON_BLACK_WHITE_ON = byteArrayOf(0x1d, 0x42, 0x01)           // 选择黑白反显
        public val COMMON_ROTATION_QUARTER_OFF = byteArrayOf(0x1b, 0x56, 0x00)    // 取消顺时针旋转90°
        public val COMMON_ROTATION_QUARTER_ON = byteArrayOf(0x1b, 0x56, 0x01)     // 选择顺时针旋转90°

    }

//    val byteCommands = arrayOf(byteArrayOf(0x1b, 0x40),// 复位打印机
//            byteArrayOf(0x1b, 0x4d, 0x00),// 标准ASCII字体
//            byteArrayOf(0x1b, 0x4d, 0x01), // 压缩ASCII字体
//            byteArrayOf(0x1d, 0x21, 0x00), // 字体不放大
//            byteArrayOf(0x1d, 0x21, 0x11), // 宽高加倍
//            byteArrayOf(0x1b, 0x45, 0x00), // 取消加粗模式
//            byteArrayOf(0x1b, 0x45, 0x01), // 选择加粗模式
//            byteArrayOf(0x1b, 0x7b, 0x00), // 取消倒置打印
//            byteArrayOf(0x1b, 0x7b, 0x01), // 选择倒置打印
//            byteArrayOf(0x1d, 0x42, 0x00), // 取消黑白反显
//            byteArrayOf(0x1d, 0x42, 0x01), // 选择黑白反显
//            byteArrayOf(0x1b, 0x56, 0x00), // 取消顺时针旋转90°
//            byteArrayOf(0x1b, 0x56, 0x01))// 选择顺时针旋转90°

    private var mDevice : BlueDevice_2_0_Imp;

    init {
        mDevice = device
    }

    public fun init(callback: IDeviceCallback){
        mDevice.connect(StandardUUID.SERIAL_PORT_UUID, false, callback)
    }

    public fun pirnt(message: ByteArray){
        mDevice.write(COMMON_STANDARD_ASCII_PRINT)
        mDevice.write(message)
    }

    public fun close(){
        mDevice.disconnect()
    }


}
