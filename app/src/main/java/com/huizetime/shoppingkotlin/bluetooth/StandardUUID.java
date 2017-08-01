package com.huizetime.shoppingkotlin.bluetooth;

import java.util.UUID;

/**
 * Created by chenjunqi on 2017/8/1.
 */

public enum StandardUUID {
    SERIAL_PORT_UUID("00001101-0000-1000-8000-00805F9B34FB"),
    INFO_ SYNC_UUID("00001104-0000-1000-8000-00805F9B34FB"),
    FILE_TRANS_UUID("00001106-0000-1000-8000-00805F9B34FB"),

    private UUID mId;

    // 构造函数，枚举类型只能为私有
    private StandardUUID( String id) {
        mId = UUID.fromString(id);
    }
}
