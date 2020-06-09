package com.na.dgsw.gongyou_android.viewmodel

import android.app.Application
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseViewModel
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent
import com.na.dgsw.gongyou_android.view.main.FileMainFragment
import com.na.dgsw.gongyou_android.view.main.StorageMainFragment


/**
 * Created by NA on 2020-04-21
 * skehdgur8591@naver.com
 */

class MainViewModel(application: Application): BaseViewModel<Any>(application), BottomNavigationView.OnNavigationItemSelectedListener {

    val storageItemEvent = SingleLiveEvent<Unit>()
    val fileItemEvent = SingleLiveEvent<Unit>()

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.storage_item -> {
                storageItemEvent.call()
                return true
            }
            R.id.file_item -> {
                fileItemEvent.call()
                return true
            }
        }
        return false
    }

}