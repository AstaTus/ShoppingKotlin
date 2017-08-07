package com.huizetime.shoppingkotlin.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

/**
 * Created by chenjunqi on 2017/8/7.
 */
class DeviceEntity: RealmObject() {

    @PrimaryKey
    public var address: String = ""

    @Required
    public var name: String = ""

    @Required
    public var type: Int = 0

    @Required
    public var  typeName: String = ""

    @Required
    public var number: String = ""

    public var pinCode: String = ""
}