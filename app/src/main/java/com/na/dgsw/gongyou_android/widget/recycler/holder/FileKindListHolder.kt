package com.na.dgsw.gongyou_android.widget.recycler.holder

import android.view.View
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.databinding.FileKindListItemBinding


/**
 * Created by NA on 2020-06-14
 * skehdgur8591@naver.com
 */

class FileKindListHolder(public var binding: FileKindListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(@NonNull itemView: View) {
        binding = DataBindingUtil.bind(itemView)!!
    }
}