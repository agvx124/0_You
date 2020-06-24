package com.na.dgsw.gongyou_android.view.waitsend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.data.network.response.FileResponse
import com.na.dgsw.gongyou_android.databinding.ActivityWaitSendBinding
import com.na.dgsw.gongyou_android.viewmodel.WaitSendViewModel

class WaitSendActivity : BaseActivity<ActivityWaitSendBinding, WaitSendViewModel>() {

    private var dataList: ArrayList<FileResponse> = ArrayList()

    override val viewModelClass: Class<WaitSendViewModel>
        get() = WaitSendViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_wait_send
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        dataList = intent.getSerializableExtra("dataList") as ArrayList<FileResponse>
        print(dataList)
    }

    override fun observerViewModel() {

    }


}