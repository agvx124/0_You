package com.na.dgsw.gongyou_android.view.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.zxing.client.android.Intents
import com.google.zxing.integration.android.IntentIntegrator
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseFragment
import com.na.dgsw.gongyou_android.data.dto.ActivityResultEvent
import com.na.dgsw.gongyou_android.data.dto.EventBus
import com.na.dgsw.gongyou_android.databinding.FragmentGetMainBinding
import com.na.dgsw.gongyou_android.view.scan.ScanActivity
import com.na.dgsw.gongyou_android.viewmodel.GetMainViewModel
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
        with(viewModel) {
            onQrCodeScannerEvent.observe(viewLifecycleOwner, Observer {
                intentIntegrator()
//                Toast.makeText(getApplication(), "PASS", Toast.LENGTH_SHORT).show()
//                startActivityForResult(Intent(requireActivity(), QrCodeActivity::class.java), REQUEST_CODE_QR_SCAN)
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