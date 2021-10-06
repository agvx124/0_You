package com.na.dgsw.gongyou_android.presentation.ui.main.fragment

import android.os.Environment
import android.os.StatFs
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseFragment
import com.na.dgsw.gongyou_android.databinding.FragmentStorageBinding
import com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel.MainViewModel
import com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel.StorageMainViewModel
import java.io.File
import java.text.DecimalFormat
import kotlin.math.log10
import kotlin.math.pow


/**
 * Created by NA on 2020-05-20
 * skehdgur8591@naver.com
 */
class StorageMainFragment : BaseFragment<FragmentStorageBinding, StorageMainViewModel>() {

    override val viewModelClass: Class<StorageMainViewModel>
        get() = StorageMainViewModel::class.java

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun observerViewModel() {

    }

    override fun setUp() {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_storage
    }


}