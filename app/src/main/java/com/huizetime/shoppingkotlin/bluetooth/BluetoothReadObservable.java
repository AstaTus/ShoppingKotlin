package com.huizetime.shoppingkotlin.bluetooth;

import android.bluetooth.BluetoothSocket;

import com.huizetime.shoppingkotlin.bluetooth.exception.CoolBluetoothReadErrorException;

import java.io.InputStream;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by chenjunqi on 2017/8/2.
 */

public class BluetoothReadObservable implements ObservableOnSubscribe<byte[]> {

    private BluetoothSocket mSocket;

    private byte[] mDataBuffer;

    private static final int BUFFER_SIZE = 1024;

    public BluetoothReadObservable(BluetoothSocket socket){
        mSocket = socket;
        mDataBuffer = new byte[BUFFER_SIZE];
    }
    @Override
    public void subscribe(ObservableEmitter<byte[]> emitter) throws Exception {

        InputStream input_stream = mSocket.getInputStream();
        int size = 0;
        while (true){

            try {
                size = input_stream.read(mDataBuffer);

                if (size == 0){

                }else if (size == -1){
                    input_stream.close();
                    emitter.onComplete();
                    break;
                }else{
                    emitter.onNext(mDataBuffer);
                }

            }catch (Exception e){
                emitter.onError(new CoolBluetoothReadErrorException());
                break;
            }
        }
    }
}
