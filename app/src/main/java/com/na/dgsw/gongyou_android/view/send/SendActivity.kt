package com.na.dgsw.gongyou_android.view.send

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.databinding.ActivitySendBinding
import com.na.dgsw.gongyou_android.viewmodel.SendViewModel

class SendActivity : BaseActivity<ActivitySendBinding, SendViewModel>() {

    override val viewModelClass: Class<SendViewModel>
        get() = SendViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_send
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {

    }

    override fun observerViewModel() {

    }
}
