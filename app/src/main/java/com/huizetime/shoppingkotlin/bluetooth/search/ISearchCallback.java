package com.huizetime.shoppingkotlin.bluetooth.search;

import com.huizetime.shoppingkotlin.bluetooth.BlueDevice_2_0_Imp;
import com.huizetime.shoppingkotlin.bluetooth.BlueDevice_4_0_Imp;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface ISearchCallback {
    
    void onStart();

    void onBL40Searching(BlueDevice_4_0_Imp device);

    void onBL20Searching(BlueDevice_2_0_Imp device);


    void onComplete();
}
