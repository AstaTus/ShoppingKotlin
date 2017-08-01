package com.huizetime.shoppingkotlin.bluetooth.exception;

/**
 * Created by chenjunqi on 2017/8/1.
 */

public class BlueTooth20NoScanRecordException extends CoolBlueToothException {

    public BlueTooth20NoScanRecordException() {

        super(ERROR_CODE_BLUETOOTH_20_NO_SCAN_RECORD, "BlueTooth 2.0 has no scan record! ");
    }
}
