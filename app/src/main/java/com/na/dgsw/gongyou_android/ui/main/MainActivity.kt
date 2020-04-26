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

    private val MainViewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        return MainViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        TODO("Not yet implemented")
    }
}
