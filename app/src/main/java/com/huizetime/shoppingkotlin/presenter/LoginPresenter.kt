package com.huizetime.shoppingkotlin.presenter

import com.huizetime.shoppingkotlin.view.ILoginView

/**
 * Created by chenjunqi on 2017/7/25.
 */

class LoginPresenter(view : ILoginView){

    private var mView : ILoginView? = null
    init {
        mView = view
    }
}
