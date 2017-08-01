package com.huizetime.shoppingkotlin.bluetooth.search;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public class CoolBluetoothSearch_4_0_Imp implements ICoolBluetoothSearcher {

    private BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private ISearchCallback mSearchCallback;

    private static final int TIMEOUT_MILLIS = 10000;

    public CoolBluetoothSearch_4_0_Imp(BluetoothAdapter adapter, Context context){
        super();
        mBluetoothAdapter = adapter;
        mContext = context;

    }

    @Override
    public void search(final ISearchCallback callback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            mBluetoothAdapter.getBluetoothLeScanner().startScan(new ScanCallback() {
                @Override
                public void onScanResult(int callbackType, ScanResult result) {
                    super.onScanResult(callbackType, result);
                }

                @Override
                public void onBatchScanResults(List<ScanResult> results) {
                    super.onBatchScanResults(results);
                }

                @Override
                public void onScanFailed(int errorCode) {
                    super.onScanFailed(errorCode);
                }
            });
        }else{
            boolean success = mBluetoothAdapter.startLeScan(new BluetoothAdapter.LeScanCallback() {
                @Override
                public void onLeScan(BluetoothDevice device, int rssi, byte[] scan_records) {

                    SearchResult r = new SearchResult(device, rssi, scan_records, System.currentTimeMillis());
                    callback.onSearching(r);
                }
            });

            if(success){
                callback.onStart();
            }

        }

    }

    @Override
    public void cancel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            mBluetoothAdapter.getBluetoothLeScanner().stopScan();
        }
    }
}
