package com.huizetime.shoppingkotlin.bluetooth;

import java.util.UUID;

/**
 * Created by Administrator on 2017/7/31.
 */

interface IBlueDevice {
    void connect(UUID service_uuid, IConnectCallback callback);


    void disconnect();

    void write(byte[] data);

    void onRead(byte[] bytes);
}
