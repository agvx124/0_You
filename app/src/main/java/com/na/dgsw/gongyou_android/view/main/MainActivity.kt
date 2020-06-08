package com.na.dgsw.gongyou_android.view.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.os.StatFs
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
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

    private val permissionList = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override val viewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        checkPermission()
        val fragmentStorage = StorageMainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentStorage).commit()

//        binding.navigationView.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.storage_item -> {
//                    val fragmentStorage = StorageMainFragment()
//                    supportActionBar?.title = "저장공간"
//                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentStorage).commit()
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.file_item -> {
//                    val fileMainFragment = FileMainFragment()
//                    supportActionBar?.title = "파일탐색"
//                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fileMainFragment).commit()
//                    return@setOnNavigationItemSelectedListener true
//                }
//            }
//            false
//        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_titlebar, menu)
        return true
    }

    override fun observerViewModel() {
        with(viewModel) {
            storageItemEvent.observe(this@MainActivity, Observer {
                val fragmentStorage = StorageMainFragment()
                supportActionBar?.title = "저장공간"
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentStorage).commit()
            })

            fileItemEvent.observe(this@MainActivity, Observer {
                val fileMainFragment = FileMainFragment()
                supportActionBar?.title = "파일탐색"
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fileMainFragment).commit()
            })
        }
    }

    private fun checkPermission() {
        for (permission in permissionList) {
            val check = checkCallingOrSelfPermission(permission)

            // 권한 허용 여부 판단
            if (check == PackageManager.PERMISSION_DENIED)
                requestPermissions(permissionList, 0)
        }
    }


}

