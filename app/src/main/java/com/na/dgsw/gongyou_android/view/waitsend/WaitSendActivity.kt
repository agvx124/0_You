package com.na.dgsw.gongyou_android.view.waitsend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import androidx.lifecycle.Observer
import com.github.sumimakito.awesomeqr.AwesomeQrRenderer
import com.github.sumimakito.awesomeqr.RenderResult
import com.github.sumimakito.awesomeqr.option.RenderOption
import com.github.sumimakito.awesomeqr.option.color.Color
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.Constants
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.data.network.response.FileResponse
import com.na.dgsw.gongyou_android.databinding.ActivityWaitSendBinding
import com.na.dgsw.gongyou_android.viewmodel.WaitSendViewModel
import java.lang.StringBuilder
import java.sql.Date
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

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

        binding.eigenValueTextView.text = setTwoCharSpacing(dataList.get(0).fileEigenValue.toString())

        var renderOption = RenderOption()
        renderOption = setRenderOption(renderOption)

        // QR Code Create
        AwesomeQrRenderer.renderAsync(renderOption, { result ->
            if (result.bitmap != null) binding.qrCreateImageView.setImageBitmap(result.bitmap)
        }, { exception -> exception.printStackTrace() })

    }

    override fun observerViewModel() {
        with(viewModel) {
            currentTime.observe(this@WaitSendActivity, Observer {
                binding.remainTimeTextView.text = DateUtils.formatElapsedTime(it)
            })
        }
    }

    private fun setRenderOption(renderOption: RenderOption): RenderOption {
        // 해당 URL 주소
        renderOption.content = Constants.DEFAULT_HOST + ""
        renderOption.size = 800
        renderOption.borderWidth = 20
        renderOption.patternScale = 0.35f
        renderOption.roundedPatterns = true
        renderOption.clearBorder = true

        return renderOption
    }

    private fun setTwoCharSpacing(str: String): String {
        var result = StringBuilder()

        for (i in 0.. str.length) {
            if ((i + 1) % 2 == 0) {
                result.append(str.get(i) + " ")
                if (i + 1 == str.length) break
            }
            else {
                result.append(str.get(i))
            }
        }

        return result.toString()
    }


}