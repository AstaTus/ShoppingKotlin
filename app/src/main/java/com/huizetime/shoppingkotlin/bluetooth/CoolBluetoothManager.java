package com.huizetime.shoppingkotlin.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;

import com.huizetime.shoppingkotlin.bluetooth.search.CoolBluetoothSearcher_2_0_Imp;
import com.huizetime.shoppingkotlin.bluetooth.search.ICoolBluetoothSearcher;
import com.huizetime.shoppingkotlin.bluetooth.search.ISearchCallback;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public class CoolBluetoothManager {

    private List<ICoolBluetoothSearcher> mSearchers;
    private Context mContext;
    private BluetoothAdapter mBluetoothAdapter;

    private ICoolBluetoothSearcher mCoolBluetoothSearcher_2_0_Imp;
    private ICoolBluetoothSearcher mCoolBluetoothSearcher_4_0_Imp;

    CoolBluetoothManager(Context context){
        this.mContext = context.getApplicationContext();
        BluetoothManager bluetoothManager = (BluetoothManager) context
                .getSystemService(Context.BLUETOOTH_SERVICE);

        mBluetoothAdapter = bluetoothManager.getAdapter();

        mCoolBluetoothSearcher_2_0_Imp = new CoolBluetoothSearcher_2_0_Imp(mBluetoothAdapter, mContext);


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

    public void search(ISearchCallback search_callback){

        //search 2.0
        mCoolBluetoothSearcher_2_0_Imp.search(search_callback);



    }

    public void searchByName(String name, ISearchCallback search_callback){

    }

    public void searchByMac(String mac, ISearchCallback search_callback){

    }
}
