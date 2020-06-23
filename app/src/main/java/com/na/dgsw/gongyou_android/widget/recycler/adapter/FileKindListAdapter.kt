package com.na.dgsw.gongyou_android.widget.recycler.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.databinding.FileKindListItemBinding
import com.na.dgsw.gongyou_android.viewmodel.FileMainViewModel
import com.na.dgsw.gongyou_android.widget.recycler.holder.FileKindListHolder


/**
 * Created by NA on 2020-05-21
 * skehdgur8591@naver.com
 */
class FileKindListAdapter(private val context: Context): RecyclerView.Adapter<FileKindListHolder>() {

    var fileKindList = listOf<FileKind>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileKindListHolder {
        val binding = FileKindListItemBinding.inflate(LayoutInflater.from(parent.context))
        return FileKindListHolder(binding)
    }

    override fun getItemCount(): Int {
        return fileKindList.size
    }

    override fun onBindViewHolder(holder: FileKindListHolder, position: Int) {
        holder.bind(fileKindList[position])
    }

}