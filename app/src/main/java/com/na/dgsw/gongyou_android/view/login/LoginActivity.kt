package com.na.dgsw.gongyou_android.view.login

import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.databinding.ActivityLoginBinding
import com.na.dgsw.gongyou_android.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override val viewModelClass: Class<LoginViewModel>
        get() = LoginViewModel::class.java

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        TODO("Not yet implemented")
    }

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }


}
