package com.na.dgsw.gongyou_android.view.main

import android.os.Environment
import android.os.StatFs
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.databinding.ActivityMainBinding
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.viewmodel.MainViewModel
import java.io.File
import java.text.DecimalFormat
import kotlin.math.log10
import kotlin.math.pow

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
        val fragmentStorage = StorageMainFragment()
        print("PASS STORAGE")
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentStorage).commit()
        
        mViewDataBinding.navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.storage_item -> {
                    val fragmentStorage = StorageMainFragment()
                    print("PASS STORAGE")
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentStorage).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.file_item -> {
                    val fileMainFragment = FileMainFragment()
                    print("PASS FILE")
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fileMainFragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
//        mViewDataBinding.remainStorageTextView.text = checkExternalAvailableMemory(true)
//        mViewDataBinding.totalStorageTextView.text = checkExternalStorageAllMemory(true)
//
//        val value: Int = (checkExternalAvailableMemory(false).toDouble() / checkExternalStorageAllMemory(false).toDouble() * 100.0).toInt()
//        mViewDataBinding.remainStorageProgressBar.progress = value

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_titlebar, menu)
        return true
    }

    override fun observerViewModel() {

    }

//    private fun isExternalMemoryAvailable(): Boolean {
//        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)
//    }
//
//    private fun checkExternalStorageAllMemory(checkVal: Boolean): String {
//
//        return if (isExternalMemoryAvailable()) {
//            val statFs = StatFs(Environment.getExternalStorageDirectory().path)
//            val blockSize: Long = statFs.blockSizeLong
//            val totalBlock: Long = statFs.blockCountLong
//
//            if (checkVal) {
//                getFileSizeVal(blockSize * totalBlock)
//            }
//            else {
//                getFileSize(blockSize * totalBlock)
//            }
//
//        }
//        else {
//            getFileSizeVal(0)
//        }
//    }
//
//    private fun checkExternalAvailableMemory(checkVal: Boolean): String {
//        return if (isExternalMemoryAvailable()) {
//            val file: File = Environment.getExternalStorageDirectory()
//            val statFs = StatFs(file.path)
//            val blockSize: Long = statFs.blockSizeLong
//            val availableBlocks: Long = statFs.availableBlocksLong
//
//            if (checkVal) {
//                getFileSizeVal(blockSize * availableBlocks)
//            }
//            else {
//                getFileSize(blockSize * availableBlocks)
//            }
//        }
//        else {
//            getFileSizeVal(0)
//        }
//    }
//
//    private fun getFileSizeVal(size: Long): String {
//        if (size <= 0) return "0"
//
//        val units: Array<String> = arrayOf("B", "KB", "MB", "GB", "TB");
//        val digitGroups: Int = (log10(size.toDouble()) / log10(1024.0)).toInt()
//        return DecimalFormat("#,##0.#").format(size / 1024.0.pow(digitGroups.toDouble())) + " " + units[digitGroups]
//    }
//
//    private fun getFileSize(size: Long): String {
//        if (size <= 0) return "0"
//
//        val digitGroups: Int = (log10(size.toDouble()) / log10(1024.0)).toInt()
//        return DecimalFormat("#,##0.#").format(size / 1024.0.pow(digitGroups.toDouble()))
//    }


}

