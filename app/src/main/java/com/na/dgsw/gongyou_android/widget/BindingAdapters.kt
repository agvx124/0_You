package com.na.dgsw.gongyou_android.widget

import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


/**
 * Created by NA on 2020-06-08
 * skehdgur8591@naver.com
 */

@BindingAdapter("onNavigationItemSelected")
fun setOnNavigationItemSelected(view: BottomNavigationView, listener: BottomNavigationView.OnNavigationItemSelectedListener) {
    view.setOnNavigationItemSelectedListener(listener)
}

