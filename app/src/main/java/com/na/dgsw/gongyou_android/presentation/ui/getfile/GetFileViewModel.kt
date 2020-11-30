package com.na.dgsw.gongyou_android.presentation.ui.getfile

import android.app.Application
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseViewModel
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent


/**
 * Created by NA on 2020-07-08
 * skehdgur8591@naver.com
 */
class GetFileViewModel(application: Application): BaseViewModel<Any>(application) {

    val cancelBtnClickEvent = SingleLiveEvent<Unit>()
    val getBtnClickEvent = SingleLiveEvent<Unit>()


    fun onCancelBtnClick() {
        cancelBtnClickEvent.call()
    }

    fun onGetBtnClick() {
        getBtnClickEvent.call()
    }

}