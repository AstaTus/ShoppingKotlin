package com.huizetime.shoppingkotlin.service;

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.huizetime.shoppingkotlin.device.Printer

/**
 * Created by chenjunqi on 2017/8/3.
 */

public class PrinterService() : Service() {

    private val mPrinterBinder : Printer? = null
    
    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
