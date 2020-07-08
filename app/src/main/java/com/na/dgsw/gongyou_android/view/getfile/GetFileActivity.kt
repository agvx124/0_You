package com.na.dgsw.gongyou_android.view.getfile

import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.databinding.ActivityGetFileBinding
import com.na.dgsw.gongyou_android.viewmodel.GetFileViewModel
import com.na.dgsw.gongyou_android.viewmodel.GetMainViewModel


/**
 * Created by NA on 2020-07-07
 * skehdgur8591@naver.com
 */
class GetFileActivity: BaseActivity<ActivityGetFileBinding, GetFileViewModel>() {

    override val viewModelClass: Class<GetFileViewModel>
        get() = GetFileViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_get_file
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {

    }

    override fun observerViewModel() {

    }
}