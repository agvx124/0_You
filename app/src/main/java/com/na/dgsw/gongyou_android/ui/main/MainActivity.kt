package com.na.dgsw.gongyou_android.ui.main

import android.os.Bundle
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.databinding.ActivityMainBinding
import com.na.dgsw.gongyou_android.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by NA on 2020-04-16
 * skehdgur8591@naver.com
 */

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mMainViewModel : MainViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): MainViewModel {
//        mMainViewModel.setNavigator(this)
        return mMainViewModel
    }

    override fun setUp() {
        TODO("Not yet implemented")
    }
}
