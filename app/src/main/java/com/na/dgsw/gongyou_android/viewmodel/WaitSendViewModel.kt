package com.na.dgsw.gongyou_android.viewmodel

import android.app.Application
import android.os.CountDownTimer
import android.view.View
import android.widget.AdapterView
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.na.dgsw.gongyou_android.base.BaseViewModel
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent
import kotlin.concurrent.timer


/**
 * Created by NA on 2020-06-14
 * skehdgur8591@naver.com
 */
class WaitSendViewModel(application: Application): BaseViewModel<Any>(application) {
    // 600000L = 600sec = 10min
    val COUNTDOWN_TIMER = 600000L
    val ONE_SECOND = 1000L
    val DONE = 0L

    val onTimeOverEvent = MutableLiveData<Boolean>()

    var timer: CountDownTimer
    val currentTime = MutableLiveData<Long>()

    init {
        timer = object :CountDownTimer(COUNTDOWN_TIMER, ONE_SECOND) {
            override fun onFinish() {
                onTimeOverEvent.value = true
                currentTime.value = DONE
            }

            override fun onTick(millisUntilFinished: Long) {
                currentTime.value = millisUntilFinished / ONE_SECOND
            }
        }

        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}