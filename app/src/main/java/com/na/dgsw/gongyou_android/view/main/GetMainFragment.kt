package com.na.dgsw.gongyou_android.view.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.blikoon.qrcodescanner.QrCodeActivity
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseFragment
import com.na.dgsw.gongyou_android.databinding.FragmentGetMainBinding
import com.na.dgsw.gongyou_android.viewmodel.GetMainViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

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

    private val REQUEST_CODE_QR_SCAN = 101

    override val viewModelClass: Class<GetMainViewModel>
        get() = GetMainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.fragment_get_main
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {

    }

    override fun observerViewModel() {
        with(viewModel) {
            onQrCodeScannerEvent.observe(this@GetMainFragment, Observer {
                startActivityForResult(Intent(requireActivity(), QrCodeActivity::class.java), REQUEST_CODE_QR_SCAN)
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_QR_SCAN) {
            if (data == null) {
                Toast.makeText(requireContext(), "QR 코드 내용이 없습니다.", Toast.LENGTH_LONG).show()
                return
            }

            val result = data.getStringExtra("com.blikoon.qrcodescanner.got_qr_scan_relult")
            Toast.makeText(requireContext(), result, Toast.LENGTH_LONG).show()
        }
    }
}