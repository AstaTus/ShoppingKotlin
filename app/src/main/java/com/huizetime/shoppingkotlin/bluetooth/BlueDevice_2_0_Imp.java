package com.huizetime.shoppingkotlin.bluetooth;

import android.bluetooth.BluetoothSocket;

import com.huizetime.shoppingkotlin.bluetooth.search.SearchResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/31.
 */

public class BlueDevice_2_0_Imp implements IBlueDevice {

    private SearchResult mSearchResult = null;
    private BluetoothSocket mSocket =  null;

    private OutputStream mOutputStream;
    private InputStream mInputStream;
    private IConnectCallback mCallback;

    public BlueDevice_2_0_Imp(SearchResult r){
        mSearchResult = r;
    }

    @Override
    public void connect(UUID service_uuid, IConnectCallback callback) {

        mCallback = callback;
        try {
            mSocket = mSearchResult.getDevice().createRfcommSocketToServiceRecord(service_uuid);

            //阻塞操作
            mSocket.connect();
            mOutputStream = mSocket.getOutputStream();
            mInputStream = mSocket.getInputStream();

            mCallback.connectSuccess();

        } catch (IOException e) {
            e.printStackTrace();
            mCallback.connectFailure();
        }
    }

    @Override
    public void disconnect() {
        try {
            mSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(byte[] data) {

    }

    @Override
    public void onRead(byte[] bytes) {

    }
}
