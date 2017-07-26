package com.huizetime.shoppingkotlin.service

/**
 * Created by chenjunqi on 2017/7/26.
 */
class ProcessServicePool {

    var mServiceSet : HashSet<Service>

    init {
        mServiceSet = HashSet<Service>()
    }

    internal fun add(service : Service){
        mServiceSet.add(service)
    }

    internal fun remove(service: Service){
        mServiceSet.remove(service)
    }

    public fun cancel(service: Service){
        service.cancel()
        remove(service)
    }

    public fun cancelAllService(){
        for (s : Service in mServiceSet) {
            s.cancel();
        }

        mServiceSet.clear()

    }
}