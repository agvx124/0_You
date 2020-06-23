package com.na.dgsw.gongyou_android.widget

import android.widget.AdapterView
import android.widget.ListView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.widget.recycler.adapter.FileKindListAdapter


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
    @BindingAdapter("bind_verAdapter")
    fun setBindItems(recyclerView: RecyclerView, adapter: FileKindListAdapter) {
        val linearLayoutManager = LinearLayoutManager(recyclerView.context)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }
}

