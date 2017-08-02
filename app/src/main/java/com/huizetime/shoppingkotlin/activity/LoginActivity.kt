package com.huizetime.shoppingkotlin

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.huizetime.shoppingkotlin.di.component.DaggerILoginActivityComponent
import com.huizetime.shoppingkotlin.di.module.LoginActivityModule
import com.huizetime.shoppingkotlin.presenter.LoginPresenter
import com.huizetime.shoppingkotlin.view.ILoginView
import javax.inject.Inject


class LoginActivity : Activity(), ILoginView {

    @Inject
    lateinit var mLoginPresenter: LoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        DaggerILoginActivityComponent.builder().loginActivityModule(LoginActivityModule(this)).build()
    }

}