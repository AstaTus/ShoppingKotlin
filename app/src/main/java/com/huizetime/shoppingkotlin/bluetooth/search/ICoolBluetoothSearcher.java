package com.huizetime.shoppingkotlin.bluetooth.search;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface ICoolBluetoothSearcher {

    void search(ISearchCallback callback);

    void cancel();
}
