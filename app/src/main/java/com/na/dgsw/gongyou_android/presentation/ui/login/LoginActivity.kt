package com.na.dgsw.gongyou_android.presentation.ui.login

import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseActivity
import com.na.dgsw.gongyou_android.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(LoginViewModel::class) {

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
