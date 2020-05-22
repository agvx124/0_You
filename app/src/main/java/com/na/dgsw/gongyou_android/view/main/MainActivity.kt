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
                    supportActionBar?.title = "저장공간"
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentStorage).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.file_item -> {
                    val fileMainFragment = FileMainFragment()
                    print("PASS FILE")
                    supportActionBar?.title = "파일탐색"
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fileMainFragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_titlebar, menu)
        return true
    }

    override fun observerViewModel() {

    }


}

