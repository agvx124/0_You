package com.na.dgsw.gongyou_android.viewmodel

import android.app.Application
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseViewModel
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent
import com.na.dgsw.gongyou_android.view.main.FileMainFragment
import com.na.dgsw.gongyou_android.view.main.StorageMainFragment
import kotlinx.android.synthetic.main.fragment_file.*


/**
 * Created by NA on 2020-04-21
 * skehdgur8591@naver.com
 */

class MainViewModel(application: Application): BaseViewModel<Any>(application), BottomNavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    val storageItemEvent = SingleLiveEvent<Unit>()
    val fileItemEvent = SingleLiveEvent<Unit>()

    val imgItemEvent = SingleLiveEvent<Unit>()
    val videoItemEvent = SingleLiveEvent<Unit>()
    val audioItemEvent = SingleLiveEvent<Unit>()
    val docItemEvent = SingleLiveEvent<Unit>()

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

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem = parent!!.getItemAtPosition(position) as FileKind

        when (selectedItem.name) {
            "이미지" -> imgItemEvent.call()
            "비디오" -> videoItemEvent.call()
            "오디오" -> audioItemEvent.call()
            "문서" -> docItemEvent.call()
        }

    }

}