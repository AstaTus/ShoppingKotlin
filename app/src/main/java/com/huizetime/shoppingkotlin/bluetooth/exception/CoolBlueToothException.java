package com.huizetime.shoppingkotlin.bluetooth.exception;

import com.clj.fastble.exception.BleException;

/**
 * Created by chenjunqi on 2017/8/1.
 */

public class CoolBlueToothException extends Exception {
    private static final long serialVersionUID = 8004414918500865564L;

    public static final int ERROR_CODE_TIMEOUT = 100;
    public static final int ERROR_CODE_GATT = 101;
    public static final int ERROR_CODE_OTHER = 102;
    public static final int ERROR_CODE_NOT_FOUND_DEVICE = 103;
    public static final int ERROR_CODE_BLUETOOTH_NOT_ENABLE = 104;
    public static final int ERROR_CODE_SCAN_FAILED = 105;

    public static final int ERROR_CODE_BLUETOOTH_20_NO_SCAN_RECORD = 106;


    private int code;
    private String description;

    public CoolBlueToothException(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public CoolBlueToothException setCode(int code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CoolBlueToothException setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "BleException { " +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
