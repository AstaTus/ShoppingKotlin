package com.huizetime.shoppingkotlin.bluetooth.search;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by Administrator on 2017/7/31.
 *
 * Client need to search Server, so the client has search step and server doesn't has search step
 */

public class CoolBluetoothSearcher_2_0_Imp implements ICoolBluetoothSearcher {

    private BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private ISearchCallback mSearchCallback;

    public CoolBluetoothSearcher_2_0_Imp(BluetoothAdapter adapter, Context context){
        super();
        mBluetoothAdapter = adapter;
        mContext = context;

    }
    @Override
    public void search(ISearchCallback callback) {
        mSearchCallback = callback;

        IntentFilter intent_filter = new IntentFilter();
        intent_filter.addAction(BluetoothDevice.ACTION_FOUND);
        intent_filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        intent_filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
//        intent_filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
//        intent_filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);


        BTBroadcastReceiver btBroadcastReceiver = new BTBroadcastReceiver();
        mContext.registerReceiver(btBroadcastReceiver, intent_filter);
        mBluetoothAdapter.startDiscovery();
    }

    @Override
    public void cancel(){
        mBluetoothAdapter.cancelDiscovery();
    }

    /**
     * 广播接收者
     */
    class BTBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            //找到设备通知  ACTION_FOUND,设备已配对通知  ACTION_BOND_STATE_CHANGED
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                int rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);

                //mSearchCallback.onSearching(intent);

            }else if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)){
                mSearchCallback.onStart();
            }else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                //mSearchCallback.onComplete();
            }
//            } else if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
//                // 获取蓝牙设备的连接状态
//                int connectState = device.getBondState();
//                // 已配对
//                if (connectState == BluetoothDevice.BOND_BONDED) {
//                    try {
//                        show("客户端:开始连接:");
//                        clientThread clientConnectThread = new clientThread();
//                        clientConnectThread.start();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
            }


//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (intent.getAction().equals(BluetoothDevice.ACTION_FOUND)) {
//                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//                callback.getData(new BTBean(device.getName(), device.getAddress()));
//            } else if (intent.getAction().equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
//                callback.queryOk();
//            }
//        }

    }
}
