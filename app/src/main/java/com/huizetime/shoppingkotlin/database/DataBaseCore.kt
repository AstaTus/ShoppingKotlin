package com.huizetime.shoppingkotlin.database

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by chenjunqi on 2017/8/7.
 */
class DataBaseCore(context: Context) {

    var mRealm: Realm
    companion object {
        private val DATABASE_FILE_NAME: String = "shopping.realm"
        private val DATABASE_VERSION: Long = 0
    }

    init{
        Realm.init(context);
        var config: RealmConfiguration = RealmConfiguration.Builder()
                .name(DATABASE_FILE_NAME)
                .schemaVersion(DATABASE_VERSION)
                .build()

        mRealm = Realm.getInstance(config)
    }

    public fun close(){
        mRealm.close();
    }

    internal fun getCore(): Realm{
        return mRealm
    }
}