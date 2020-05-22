package com.na.dgsw.gongyou_android.view.main

import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseFragment
import com.na.dgsw.gongyou_android.data.FileKind
import com.na.dgsw.gongyou_android.databinding.FragmentFileBinding
import com.na.dgsw.gongyou_android.viewmodel.MainViewModel
import com.na.dgsw.gongyou_android.widget.FileKindListAdapter


/**
 * Created by NA on 2020-05-18
 * skehdgur8591@naver.com
 */

class FileMainFragment : BaseFragment<FragmentFileBinding, MainViewModel>() {

    private var fileKindList = arrayListOf(
        FileKind("ic_image", "이미지"),
        FileKind("ic_video", "비디오"),
        FileKind("ic_audio", "오디오"),
        FileKind("ic_document", "문서")
    )

    override val viewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.fragment_file
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        val fileKindListAdapter = FileKindListAdapter(activity!!.applicationContext, fileKindList)
        mViewDataBinding.listView.adapter = fileKindListAdapter
    }

    override fun observerViewModel() {

    }
}