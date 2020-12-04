package com.na.dgsw.gongyou_android.presentation.ui.main.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.na.dgsw.gongyou_android.domain.entity.file.FileKind
import com.na.dgsw.gongyou_android.databinding.FileKindListItemBinding
import com.na.dgsw.gongyou_android.presentation.ui.main.recycler.OnItemClickListener


/**
 * Created by NA on 2020-05-21
 * skehdgur8591@naver.com
 */
class FileKindListAdapter(private val context: Context): RecyclerView.Adapter<FileKindListAdapter.FileKindListViewHolder>() {

    var fileKindList = listOf<FileKind>()

    lateinit var mListener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileKindListViewHolder {
        val binding = FileKindListItemBinding.inflate(LayoutInflater.from(parent.context))
        return FileKindListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fileKindList.size
    }

    override fun onBindViewHolder(holder: FileKindListViewHolder, position: Int) {
        holder.bind(fileKindList[position])
    }

    inner class FileKindListViewHolder(val binding: FileKindListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: FileKind) {
            binding.kindImg.setImageResource(data.photo)
            binding.kindTextView.text = data.name

            binding.root.setOnClickListener {
                val pos = adapterPosition;
                if (pos != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(binding.root, pos)
                }
            }
        }
    }

}