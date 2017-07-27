package com.huizetime.shoppingkotlin.di.component

import com.huizetime.shoppingkotlin.di.module.LoginActivityModule
import dagger.Component
import com.huizetime.shoppingkotlin.LoginActivity

/**
 * Created by chenjunqi on 2017/7/27.
 */
@Component(modules = arrayOf(LoginActivityModule::class))
interface ILoginActivityComponent {
    fun inject(loginActivity: LoginActivity)
}
