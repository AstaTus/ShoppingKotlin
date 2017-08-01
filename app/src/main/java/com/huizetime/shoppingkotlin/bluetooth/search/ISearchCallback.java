package com.huizetime.shoppingkotlin.bluetooth.search;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface ISearchCallback {
    void onStart();

    void onSearching(SearchResult result);

    void onComplete(List<SearchResult> results);
}
