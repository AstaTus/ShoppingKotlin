package com.huizetime.shoppingkotlin.bluetooth;

import android.bluetooth.BluetoothSocket;

import com.huizetime.shoppingkotlin.bluetooth.exception.CoolBluetoothAlreadyConnectException;
import com.huizetime.shoppingkotlin.bluetooth.search.SearchResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/7/31.
 */

public class BlueDevice_2_0_Imp implements IBlueDevice {

    public SearchResult mSearchResult = null;
    private BluetoothSocket mSocket =  null;

    private OutputStream mOutputStream = null;
    private IDeviceCallback mCallback = null;

    private Observable mReadObservable = null;

    public BlueDevice_2_0_Imp(SearchResult r){
        mSearchResult = r;
    }

    @Override
    public void connect(UUID service_uuid, boolean read_enable, IDeviceCallback callback) throws Exception {

        if (mSocket != null)
            throw new CoolBluetoothAlreadyConnectException() ;

        mCallback = callback;
        try {
            mSocket = mSearchResult.getDevice().createRfcommSocketToServiceRecord(service_uuid);

            //阻塞操作
            mCallback.onConnecting();
            mSocket.connect();
            mCallback.onConnectSuccess();

            mOutputStream = mSocket.getOutputStream();

            if (read_enable){
                enableRead();
            }

        } catch (IOException e) {
            e.printStackTrace();
            mCallback.onConnectFailure();
        }
    }

    @Override
    public void disconnect() {
        try {
            mOutputStream.close();
            mSocket.close();
            mReadObservable.unsubscribeOn(Schedulers.io());
            mCallback.onDisConnected();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(byte[] data) {

        try {
            mOutputStream.write(data);
            mOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            mCallback.onWriteFailure();
        }


    }

    private void enableRead(){

        mReadObservable = Observable.create(new BluetoothReadObservable(mSocket));
        mReadObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BluetoothReadObsersver(mCallback));
    }
}
