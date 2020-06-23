package com.na.dgsw.gongyou_android.widget.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.databinding.FileKindListItemBinding
import com.na.dgsw.gongyou_android.widget.recycler.OnItemClickListener
import com.vincent.filepicker.activity.VideoPickActivity
import kotlin.math.acos


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

//        holder.binding.parentLayout.setOnClickListener {
//            val activity: Activity = context as Activity
//            when (fileKindList[position].name) {
//                "이미지" -> {
//                    val intent = Intent(context.applicationContext, ImagePickActivity::class.java)
//                    intent.putExtra(ImagePickActivity.IS_NEED_CAMERA, true)
//                    intent.putExtra(Constant.MAX_NUMBER, 9)
//                    activity.startActivityForResult(intent, Constant.REQUEST_CODE_PICK_IMAGE)
//                }
//                "비디오" -> {
//                    val intent = Intent(activity!!.application, VideoPickActivity::class.java)
//                    intent.putExtra(VideoPickActivity.IS_NEED_CAMERA, true)
//                    intent.putExtra(Constant.MAX_NUMBER, 9)
//                    activity.startActivityForResult(intent, Constant.REQUEST_CODE_PICK_VIDEO)
//                }
//                "오디오" -> {
//                    val intent = Intent(activity!!.application, AudioPickActivity::class.java)
//                    intent.putExtra(AudioPickActivity.IS_NEED_RECORDER, true)
//                    intent.putExtra(Constant.MAX_NUMBER, 9)
//                    activity.startActivityForResult(intent, Constant.REQUEST_CODE_PICK_AUDIO)
//                }
//                "문서" -> {
//                    val intent = Intent(activity!!.application, NormalFilePickActivity::class.java)
//                    intent.putExtra(NormalFilePickActivity.SUFFIX, arrayOf("xlsx", "xls", "doc", "docx", "ppt", "pptx", "pdf"))
//                    intent.putExtra(Constant.MAX_NUMBER, 9)
//                    activity.startActivityForResult(intent, Constant.REQUEST_CODE_PICK_FILE)
//                }
//            }
//        }
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