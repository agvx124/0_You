package com.na.dgsw.gongyou_android.activity.main

import android.os.Environment
import android.os.StatFs
import android.util.Log
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.databinding.ActivityMainBinding
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.io.File
import java.lang.StringBuilder
import java.text.DecimalFormat

/**
 * Created by NA on 2020-04-16
 * skehdgur8591@naver.com
 */

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        getViewDataBinding().totalStorageTextView.setText(getTotalInternalMemorySize())
    }

    override fun observerViewModel() {

    }

    private fun isExternalMemoryAvailable(): Boolean {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)
    }

    private fun getTotalInternalMemorySize(): String {

        if (isExternalMemoryAvailable()) {
            var statFs: StatFs = StatFs(Environment.getExternalStorageDirectory().path)
            var blockSize: Long = statFs.blockSizeLong
            var totalBlock: Long = statFs.blockCountLong

            return getFileSize(blockSize * totalBlock)
        }
        else {
            return getFileSize(0)
        }


//        var path: File = Environment.getDataDirectory();
//        var stat: StatFs = StatFs(path.path)
//        var blockSize: Long = stat.blockSizeLong
//        var totalBlocks: Long = stat.blockCountLong

//        return getFileSize(totalBlocks * blockSize);
    }

    private fun getFileSize(size: Long): String {
        if (size <= 0) return "0"

        val units: Array<String> = arrayOf("B", "KB", "MB", "GB", "TB");
        var digitGroups: Int = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt()
        return DecimalFormat("#,##0.#").format(size / Math.pow(1024.0, digitGroups.toDouble())) + " " + units[digitGroups]
    }

//    fun formatSize(size: Long): String {
//        var suffix: String? = null
//        var sizeIndex: Long = size;
//
//        if (sizeIndex >= 1024) {
//            suffix = " KB"
//            sizeIndex /= 1024
//            if (sizeIndex >= 1024) {
//                suffix = " MB"
//                sizeIndex /= 1024
//            }
//        }
//
//        var resultBuffer: StringBuilder = StringBuilder(sizeIndex.toString())
//
//        var commaOffset: Int = resultBuffer.length - 3
//        while (commaOffset > 0) {
//            resultBuffer.insert(commaOffset, ',')
//            commaOffset -= 3
//        }
//
//        if (suffix != null) resultBuffer.append(suffix)
//
//        return resultBuffer.toString()
//    }

}

