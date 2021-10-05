package com.na.dgsw.gongyou_android.utils

import android.os.Handler
import com.squareup.otto.Bus
import android.os.Looper

/**
 * Created by NA on 2020-07-07
 * skehdgur8591@naver.com
 */
class EventBus : Bus() {
    private val handler = Handler(Looper.getMainLooper())
    override fun post(event: Any) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event)
        } else {
            handler.post { super@EventBus.post(event) }
        }
    }

    companion object {
        var instance: EventBus? = null
            get() {
                if (field == null) {
                    synchronized(EventBus::class.java) {
                        if (field == null) {
                            field = EventBus()
                        }
                    }
                }
                return field
            }
            private set
    }
}