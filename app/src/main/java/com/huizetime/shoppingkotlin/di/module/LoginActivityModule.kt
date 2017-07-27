package com.huizetime.shoppingkotlin.di.module

import com.huizetime.shoppingkotlin.presenter.LoginPresenter
import com.huizetime.shoppingkotlin.view.ILoginView
import dagger.Module
import dagger.Provides

/**
 * Created by chenjunqi on 2017/7/27.
 */

@Module
public class LoginActivityModule(view : ILoginView) {

    private var mView : ILoginView

    init {
        mView = view
    }

    @Provides
    public fun providePresenter(view : ILoginView) : LoginPresenter {
        return LoginPresenter(view)
    }

    @Provides
    public fun provideView() : ILoginView {
        return mView;
    }
}