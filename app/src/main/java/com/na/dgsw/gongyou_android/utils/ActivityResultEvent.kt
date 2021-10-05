package com.na.dgsw.gongyou_android.utils

import android.content.Intent
import com.na.dgsw.gongyou_android.utils.ActivityResultEvent

/**
 * Created by NA on 2020-07-07
 * skehdgur8591@naver.com
 */
class ActivityResultEvent(var requestCode: Int, var resultCode: Int, var data: Intent) {

    companion object {
        fun create(requestCode: Int, resultCode: Int, intent: Intent): ActivityResultEvent {
            return ActivityResultEvent(requestCode, resultCode, intent)
        }
    }
}