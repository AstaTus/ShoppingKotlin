package com.huizetime.shoppingkotlin.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;

import com.huizetime.shoppingkotlin.bluetooth.search.ICoolBluetoothSearcher;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public class CoolBluetoothManager {

    private List<ICoolBluetoothSearcher> mSearchers;
    private Context mContext;
    private BluetoothAdapter mBluetoothAdapter;

    CoolBluetoothManager(Context context){
        this.mContext = context.getApplicationContext();
        BluetoothManager bluetoothManager = (BluetoothManager) context
                .getSystemService(Context.BLUETOOTH_SERVICE);

        mBluetoothAdapter = bluetoothManager.getAdapter();
    }

    public void enable(){
        if(!isEnabled()){
            mBluetoothAdapter.enable();
        }
    }

    public void disable(){
        if(isEnabled()){
            mBluetoothAdapter.disable();
        }
    }

    public boolean isEnabled(){
        return mBluetoothAdapter.isEnabled();
    }

    /*is 4.0 BlueTooth Enabled
    * */
    public boolean isSupportBle() {
        return mContext.getApplicationContext()
                .getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE);
    }

    public void search(){

    }

}
