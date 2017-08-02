package com.huizetime.shoppingkotlin.bluetooth;

import com.huizetime.shoppingkotlin.bluetooth.exception.CoolBluetoothReadErrorException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by chenjunqi on 2017/8/2.
 */

public class BluetoothReadObsersver implements Observer<byte[]> {

    private IDeviceCallback mCallback;
    private Disposable mDisposable;

    BluetoothReadObsersver(IDeviceCallback callback){
        mCallback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(byte[] data_buffer) {
        mCallback.onRead(data_buffer);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof CoolBluetoothReadErrorException){
            mCallback.onReadFailure();
        }

    }

    @Override
    public void onComplete() {

    }
}
