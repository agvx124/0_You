package com.na.dgsw.gongyou_android.view.send

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.databinding.ActivitySendBinding
import com.na.dgsw.gongyou_android.view.main.MainActivity
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
        val intent = intent
        val dataUrls = intent.getStringExtra("dataUrl")

        val arrayUrl: ArrayList<String> = dataUrls.split("\n") as ArrayList<String>

        // "" null Check
        for (fileUrl in arrayUrl) {
            if (fileUrl == "") arrayUrl.remove("")
        }

        binding.fileSizeTextView.text = "선택한 파일 " + arrayUrl.size + "개를 보내겠습니까?"


        binding.sendBtn.setOnClickListener({
            var root = "";
        })

        binding.cancelBtn.setOnClickListener {
            var builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("보내기 취소")
            builder.setMessage("파일 보내기를 취소하시겠습니까?")
            builder.setPositiveButton("아니오") { dialog, which ->

            }
            builder.setNegativeButton("예") { dialog, which ->
                startActivity(Intent(this, MainActivity::class.java))
            }.show()
        }

    }

    override fun observerViewModel() {

    }
}
