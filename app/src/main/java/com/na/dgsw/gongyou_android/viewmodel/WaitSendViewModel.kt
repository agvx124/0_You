package com.na.dgsw.gongyou_android.viewmodel

import android.app.Application
import android.view.View
import android.widget.AdapterView
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.na.dgsw.gongyou_android.base.BaseViewModel
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent


/**
 * Created by NA on 2020-06-14
 * skehdgur8591@naver.com
 */
class WaitSendViewModel(application: Application): BaseViewModel<Any>(application) {

    var onTimerValue = ObservableField<String>()

    init {
        
    }

}