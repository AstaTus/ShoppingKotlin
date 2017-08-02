package com.huizetime.shoppingkotlin.bluetooth;

/**
 * Created by chenjunqi on 2017/8/1.
 */

public interface IDeviceCallback {

    void onConnecting();

    void onConnectFailure();

    void onConnectSuccess();

    void onDisConnected();

    void onReadFailure();

    void onWriteFailure();

    void onRead(byte[] data);
}
