package com.na.dgsw.gongyou_android.presentation.ui.main.viewmodel

import android.app.Application
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseViewModel
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent


/**
 * Created by NA on 2020-04-21
 * skehdgur8591@naver.com
 */

class MainViewModel(application: Application): BaseViewModel<Any>(application), BottomNavigationView.OnNavigationItemSelectedListener {

    val storageItemEvent = SingleLiveEvent<Unit>()
    val sendFileItemEvent = SingleLiveEvent<Unit>()
    val getFileItemEvent = SingleLiveEvent<Unit>()

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.storage_item -> {
                storageItemEvent.call()
                return true
            }
            R.id.file_item -> {
                sendFileItemEvent.call()
                return true
            }
            R.id.file_get_item -> {
                getFileItemEvent.call()
                return true
            }
        }
        return false
    }

}