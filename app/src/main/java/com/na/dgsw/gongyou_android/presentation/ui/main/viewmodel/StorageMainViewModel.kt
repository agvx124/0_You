package com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel

import android.app.Application
import android.os.Environment
import android.os.StatFs
import androidx.lifecycle.MutableLiveData
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseViewModel
import java.io.File
import java.text.DecimalFormat
import kotlin.math.log10
import kotlin.math.pow


/**
 * Created by NA on 2020-12-04
 * skehdgur8591@naver.com
 */
class StorageMainViewModel(application: Application): BaseViewModel<Any>(application) {

    val remainProgressValue = MutableLiveData<Double>()

    fun checkExternalStorageAllMemory(checkVal: Boolean): String {

        return if (isExternalMemoryAvailable()) {
            val statFs = StatFs(Environment.getExternalStorageDirectory().path)
            val blockSize: Long = statFs.blockSizeLong
            val totalBlock: Long = statFs.blockCountLong

            if (checkVal) {
                getFileSizeVal(blockSize * totalBlock)
            }
            else {
                getFileSize(blockSize * totalBlock)
            }
        }
        else {
            getFileSizeVal(0)
        }
    }

    fun checkExternalAvailableMemory(checkVal: Boolean): String {
        return if (isExternalMemoryAvailable()) {
            val file: File = Environment.getExternalStorageDirectory()
            val statFs = StatFs(file.path)
            val blockSize: Long = statFs.blockSizeLong
            val availableBlocks: Long = statFs.availableBlocksLong

            if (checkVal) {
                getFileSizeVal(blockSize * availableBlocks)
            }
            else {
                getFileSize(blockSize * availableBlocks)
            }
        }
        else {
            getFileSizeVal(0)
        }
    }

    private fun getFileSizeVal(size: Long): String {
        if (size <= 0) return "0"

        val units: Array<String> = arrayOf("B", "KB", "MB", "GB", "TB");
        val digitGroups: Int = (log10(size.toDouble()) / log10(1024.0)).toInt()
        return DecimalFormat("#,##0.#").format(size / 1024.0.pow(digitGroups.toDouble())) + " " + units[digitGroups]
    }

    private fun getFileSize(size: Long): String {
        if (size <= 0) return "0"

        val digitGroups: Int = (log10(size.toDouble()) / log10(1024.0)).toInt()
        return DecimalFormat("#,##0.#").format(size / 1024.0.pow(digitGroups.toDouble()))
    }

    private fun isExternalMemoryAvailable(): Boolean {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)
    }
}