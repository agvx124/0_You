package com.na.dgsw.gongyou_android.presentation.ui.waitsend

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseViewModel


/**
 * Created by NA on 2020-06-14
 * skehdgur8591@naver.com
 */
class WaitSendViewModel(application: Application): BaseViewModel<Any>(application) {
    // 600000L = 600sec = 10min
    companion object {
        const val COUNTDOWN_TIMER = 600000L
        const val ONE_SECOND = 1000L
        const val DONE = 0L
    }


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