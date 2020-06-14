package com.na.dgsw.gongyou_android.widget

import android.widget.AdapterView
import android.widget.ListView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.na.dgsw.gongyou_android.data.dto.FileKind


/**
 * Created by NA on 2020-06-08
 * skehdgur8591@naver.com
 */

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("onNavigationItemSelected")
    fun setOnNavigationItemSelected(view: BottomNavigationView, listener: BottomNavigationView.OnNavigationItemSelectedListener) {
        view.setOnNavigationItemSelectedListener(listener)
    }

    @JvmStatic
    @BindingAdapter("bind:item")
    fun bindItem(recyclerView: RecyclerView, fileKindList: ObservableArrayList<FileKind>) {

    }
}

