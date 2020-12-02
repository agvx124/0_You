package com.na.dgsw.gongyou_android.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.presentation.ui.main.recycler.adapter.FileKindListAdapter


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

