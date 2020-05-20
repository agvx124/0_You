package com.na.dgsw.gongyou_android.view.main

import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseFragment
import com.na.dgsw.gongyou_android.databinding.FragmentFileBinding
import com.na.dgsw.gongyou_android.viewmodel.MainViewModel


/**
 * Created by NA on 2020-05-18
 * skehdgur8591@naver.com
 */

class FileMainFragment : BaseFragment<FragmentFileBinding, MainViewModel>() {

    override val viewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.fragment_file
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {

    }

    override fun observerViewModel() {

    }
}