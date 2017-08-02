package com.huizetime.shoppingkotlin.bluetooth.search;

import com.huizetime.shoppingkotlin.bluetooth.BlueDevice_2_0_Imp;
import com.huizetime.shoppingkotlin.bluetooth.BlueDevice_4_0_Imp;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface ISearchCallback {
    void onStart();

    void onBL40Searching(BlueDevice_4_0_Imp device);

    void onBL20Searching(BlueDevice_2_0_Imp device);


    void onComplete();
}
