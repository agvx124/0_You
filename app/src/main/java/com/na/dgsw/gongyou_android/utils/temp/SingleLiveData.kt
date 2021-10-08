package com.na.dgsw.gongyou_android.utils.temp

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import kr.co.prnd.mvvmeventsample.step1.Event

abstract class SingleLiveData<T> {

    private val liveData = MutableLiveData<Event<T>>()

    protected constructor()

    protected constructor(value: T) {
        liveData.value = Event(value)
    }

    protected open fun setValue(value: T) {
        liveData.value = Event(value)
    }

    protected open fun postValue(value: T) {
        liveData.postValue(Event(value))
    }

    fun getValue() = liveData.value?.peekContent()

    fun observe(owner: LifecycleOwner, onResult: (T) -> Unit) {
        liveData.observe(owner) { it.getContentIfNotHandled()?.let(onResult) }
    }

    fun observePeek(owner: LifecycleOwner, onResult: (T) -> Unit) {
        liveData.observe(owner) { onResult(it.peekContent()) }
    }

}