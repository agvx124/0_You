package com.na.dgsw.gongyou_android.presentation.ui.main.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.view.Menu
import androidx.lifecycle.Observer
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.databinding.ActivityMainBinding
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseActivity
import com.na.dgsw.gongyou_android.utils.ActivityResultEvent
import com.na.dgsw.gongyou_android.utils.EventBus
import com.na.dgsw.gongyou_android.presentation.ui.main.fragment.GetMainFragment
import com.na.dgsw.gongyou_android.presentation.ui.main.fragment.SendMainFragment
import com.na.dgsw.gongyou_android.presentation.ui.main.fragment.StorageMainFragment
import com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel.MainViewModel

/**
 * Created by NA on 2020-04-16
 * skehdgur8591@naver.com
 */

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(MainViewModel::class) {

    private val permissionList = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)

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
        replaceStorageFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_titlebar, menu)
        return true
    }

    override fun observerViewModel() {
        with(viewModel) {
            storageItemEvent.observe(this@MainActivity, Observer {
                replaceStorageFragment()
            })

            sendFileItemEvent.observe(this@MainActivity, Observer {
                replaceSendFileFragment()
            })

            getFileItemEvent.observe(this@MainActivity, Observer {
                replaceGetFileFragment()
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        EventBus.getInstance().post(
            ActivityResultEvent.create(requestCode, resultCode, data))
    }

    private fun checkPermission() {
        for (permission in permissionList) {
            val check = checkCallingOrSelfPermission(permission)

            // 권한 허용 여부 판단
            if (check == PackageManager.PERMISSION_DENIED)
                requestPermissions(permissionList, 0)
        }
    }

    private fun replaceStorageFragment() {
        val fragmentStorage = StorageMainFragment()
        supportActionBar?.title = "저장공간"
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentStorage).commit()
    }

    private fun replaceSendFileFragment() {
        val sendFileMainFragment = SendMainFragment()
        supportActionBar?.title = "파일보내기"
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, sendFileMainFragment).commit()
    }

    private fun replaceGetFileFragment() {
        val getFileMainFragment = GetMainFragment()
        supportActionBar?.title = "파일받기"
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, getFileMainFragment).commit()
    }

}

