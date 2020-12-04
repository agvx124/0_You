package com.na.dgsw.gongyou_android.presentation.ui.main.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.zxing.client.android.Intents
import com.google.zxing.integration.android.IntentIntegrator
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseFragment
import com.na.dgsw.gongyou_android.utils.ActivityResultEvent
import com.na.dgsw.gongyou_android.utils.EventBus
import com.na.dgsw.gongyou_android.databinding.FragmentGetMainBinding
import com.na.dgsw.gongyou_android.presentation.ui.getfile.GetFileActivity
import com.na.dgsw.gongyou_android.presentation.ui.scan.ScanActivity
import com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel.GetMainViewModel
import com.squareup.otto.Subscribe

/**
 * Created by NA on 2020-04-16
 * skehdgur8591@naver.com
 */

/**
 * A simple [Fragment] subclass.
 * Use the [GetMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GetMainFragment : BaseFragment<FragmentGetMainBinding, GetMainViewModel>() {

    override val viewModelClass: Class<GetMainViewModel>
        get() = GetMainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.fragment_get_main
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        EventBus.getInstance().register(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Fragment viewmodel은 onActivityCreated 로 받아야함 ㅠㅠ
        with(viewModel) {
            onQrCodeScannerEvent.observe(viewLifecycleOwner, Observer {
                intentIntegrator()
            })

            onDownloadEvent.observe(viewLifecycleOwner, Observer {
                viewModel.getFiles(binding.keyEditText.text.toString().toInt())
            })

            onSuccessEvent.observe(viewLifecycleOwner, Observer {
                val arrayList = it as ArrayList<String>
                Toast.makeText(context, "스캔을 완료하였습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, GetFileActivity::class.java)
                intent.putExtra("fileUri", arrayList)
                startActivity(intent)
            })
        }
    }

    override fun observerViewModel() {

    }

    @SuppressWarnings("unused")
    @Subscribe
    fun onActivityResultEvent(event: ActivityResultEvent) {
        onActivityResult(event.requestCode, event.resultCode, event.data)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(context, "취소하셨습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                viewModel.getFiles(result.contents.toInt())
            }
        }

        Toast.makeText(context, "Scanned: " + data!!.getStringExtra(Intents.Scan.RESULT), Toast.LENGTH_LONG).show()
    }

    private fun intentIntegrator() {
        val intentIntegrator = IntentIntegrator(requireActivity())
        intentIntegrator.captureActivity = ScanActivity::class.java
        intentIntegrator.setPrompt("QR 코드를 사각형 안에 비춰주세요.")
        intentIntegrator.setBeepEnabled(false) // 인식 소리 - F
        intentIntegrator.initiateScan()
    }
}