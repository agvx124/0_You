package com.na.dgsw.gongyou_android.viewmodel

import android.app.Application
import android.view.View
import android.widget.AdapterView
import com.na.dgsw.gongyou_android.base.BaseViewModel
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent


/**
 * Created by NA on 2020-06-14
 * skehdgur8591@naver.com
 */
class FileMainViewModel(application: Application): BaseViewModel<Any>(application) {
    // ListView SET
    private var fileKindList = arrayListOf(
        FileKind("ic_image", "이미지"),
        FileKind("ic_video", "비디오"),
        FileKind("ic_audio", "오디오"),
        FileKind("ic_document", "문서")
    )

    val imgItemEvent = SingleLiveEvent<Unit>()
    val videoItemEvent = SingleLiveEvent<Unit>()
    val audioItemEvent = SingleLiveEvent<Unit>()
    val docItemEvent = SingleLiveEvent<Unit>()

}