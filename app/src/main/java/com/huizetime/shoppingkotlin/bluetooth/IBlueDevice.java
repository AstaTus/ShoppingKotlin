package com.huizetime.shoppingkotlin.bluetooth;

import java.util.UUID;

/**
 * Created by Administrator on 2017/7/31.
 */

interface IBlueDevice {
    void connect(UUID service_uuid, boolean read_enable, IDeviceCallback callback) throws Exception;

    void disconnect();

    void write(byte[] data);
}
