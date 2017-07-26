package com.huizetime.shoppingkotlin.network

import com.huizetime.shoppingkotlin.service.IServiceCallback
import com.orhanobut.logger.Logger
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by chenjunqi on 2017/7/26.
 */

class  HttpObsersver<T>(callback : IServiceCallback<T>) : Observer<HttpResult<T>>{

    private var mCallback : IServiceCallback<T> = callback

    private var mDisposable : Disposable? = null

    override fun onSubscribe(d: Disposable) {
        mDisposable  = d
    }

    override fun onNext(t: HttpResult<T>) {
        if (HttpState.SUCCESS.equals(t.error)){
            mCallback.onHandleSuccess(t.data as T)
        }else{
            mCallback.onHandleFailure()
        }
    }

    override fun onComplete() {
        Logger.d("HttpObsersver:onComplete")
    }

    override fun onError(e: Throwable) {
        mCallback.onError()
    }

    fun cancel(){
        mDisposable?.dispose()
    }
}