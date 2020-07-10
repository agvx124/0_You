package com.na.dgsw.gongyou_android.view.splash

import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.databinding.ActivitySplashBinding
import com.na.dgsw.gongyou_android.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override val viewModelClass: Class<SplashViewModel>
        get() = SplashViewModel::class.java

    override fun getBindingVariable(): Int {
         return BR.viewModel
    }

    override fun setUp() {

    }

    override fun observerViewModel() {

    }


}
