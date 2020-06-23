package com.na.dgsw.gongyou_android.widget.recycler.holder

import android.content.Context
import android.net.Uri
import android.view.View
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.databinding.FileKindListItemBinding
import com.na.dgsw.gongyou_android.viewmodel.FileMainViewModel
import java.net.URI
import java.net.URL


/**
 * Created by NA on 2020-06-14
 * skehdgur8591@naver.com
 */

class FileKindListHolder(val binding: FileKindListItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(data: FileKind) {
        binding.kindImg.setImageResource(data.photo)
        binding.kindTextView.text = data.name
    }
}
