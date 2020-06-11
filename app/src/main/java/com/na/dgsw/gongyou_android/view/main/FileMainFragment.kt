package com.na.dgsw.gongyou_android.view.main

import android.content.Intent
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseFragment
import com.na.dgsw.gongyou_android.data.dto.FileKind
import com.na.dgsw.gongyou_android.databinding.FragmentFileBinding
import com.na.dgsw.gongyou_android.view.send.SendActivity
import com.na.dgsw.gongyou_android.viewmodel.MainViewModel
import com.na.dgsw.gongyou_android.widget.FileKindListAdapter
import com.vincent.filepicker.Constant
import com.vincent.filepicker.activity.AudioPickActivity
import com.vincent.filepicker.activity.ImagePickActivity
import com.vincent.filepicker.activity.NormalFilePickActivity
import com.vincent.filepicker.activity.VideoPickActivity
import com.vincent.filepicker.filter.entity.AudioFile
import com.vincent.filepicker.filter.entity.ImageFile
import com.vincent.filepicker.filter.entity.NormalFile
import com.vincent.filepicker.filter.entity.VideoFile
import kotlinx.android.synthetic.main.fragment_file.*
import java.lang.StringBuilder


/**
 * Created by NA on 2020-05-18
 * skehdgur8591@naver.com
 */

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class
FileMainFragment : BaseFragment<FragmentFileBinding, MainViewModel>() {

    // ListView SET
    private var fileKindList = arrayListOf(
        FileKind("ic_image", "이미지"),
        FileKind("ic_video", "비디오"),
        FileKind("ic_audio", "오디오"),
        FileKind("ic_document", "문서")
    )

    override val viewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.fragment_file
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        val fileKindListAdapter = FileKindListAdapter(activity!!.applicationContext, fileKindList)
        binding.listView.adapter = fileKindListAdapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = listView.getItemAtPosition(position) as FileKind

            when (selectedItem.name) {
                "이미지" -> {
                    val intent = Intent(activity!!.application, ImagePickActivity::class.java)
                    intent.putExtra(ImagePickActivity.IS_NEED_CAMERA, true)
                    intent.putExtra(Constant.MAX_NUMBER, 9)
                    startActivityForResult(intent, Constant.REQUEST_CODE_PICK_IMAGE)
                }
                "비디오" -> {
                    val intent = Intent(activity!!.application, VideoPickActivity::class.java)
                    intent.putExtra(VideoPickActivity.IS_NEED_CAMERA, true)
                    intent.putExtra(Constant.MAX_NUMBER, 9)
                    startActivityForResult(intent, Constant.REQUEST_CODE_PICK_VIDEO)
                }
                "오디오" -> {
                    val intent = Intent(activity!!.application, AudioPickActivity::class.java)
                    intent.putExtra(AudioPickActivity.IS_NEED_RECORDER, true)
                    intent.putExtra(Constant.MAX_NUMBER, 9)
                    startActivityForResult(intent, Constant.REQUEST_CODE_PICK_AUDIO)
                }
                "문서" -> {
                    val intent = Intent(activity!!.application, NormalFilePickActivity::class.java)
                    intent.putExtra(NormalFilePickActivity.SUFFIX, arrayOf("xlsx", "xls", "doc", "docx", "ppt", "pptx", "pdf"))
                    intent.putExtra(Constant.MAX_NUMBER, 9)
                    startActivityForResult(intent, Constant.REQUEST_CODE_PICK_FILE)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            Constant.REQUEST_CODE_PICK_IMAGE -> {
                if (resultCode == ImagePickActivity.RESULT_OK) {
                    val list = (data!!.getParcelableArrayListExtra<ImageFile>(Constant.RESULT_PICK_IMAGE))
                    val builder = StringBuilder()
                    for (file in list) {
                        val path = file.path
                        builder.append(path + "\n")
                    }

                    val intent = Intent(activity!!.application, SendActivity::class.java)
                    intent.putExtra("dataUrl", builder.toString())
                    intent.putExtra("extension", list)
                    startActivity(intent)
                }
            }
            Constant.REQUEST_CODE_PICK_VIDEO -> {
                if (resultCode == VideoPickActivity.RESULT_OK) {
                    val list = (data!!.getParcelableArrayListExtra<VideoFile>(Constant.RESULT_PICK_IMAGE))
                    val builder = StringBuilder()
                    for (file in list) {
                        val path = file.path
                        builder.append(path + "\n")
                    }

                    val intent = Intent(activity!!.application, SendActivity::class.java)
                    intent.putExtra("dataUrl", builder.toString())
                    startActivity(intent)
                }
            }
            Constant.REQUEST_CODE_PICK_AUDIO -> {
                if (resultCode == AudioPickActivity.RESULT_OK) {
                    val list = (data!!.getParcelableArrayListExtra<AudioFile>(Constant.RESULT_PICK_IMAGE))
                    val builder = StringBuilder()
                    for (file in list) {
                        val path = file.path
                        builder.append(path + "\n")
                    }

                    val intent = Intent(activity!!.application, SendActivity::class.java)
                    intent.putExtra("dataUrl", builder.toString())
                    startActivity(intent)
                }
            }
            Constant.REQUEST_CODE_PICK_FILE -> {
                if (resultCode == NormalFilePickActivity.RESULT_OK) {
                    val list = (data!!.getParcelableArrayListExtra<NormalFile>(Constant.RESULT_PICK_IMAGE))
                    val builder = StringBuilder()
                    for (file in list) {
                        val path = file.path
                        builder.append(path + "\n")
                    }

                    val intent = Intent(activity!!.application, SendActivity::class.java)
                    intent.putExtra("dataUrl", builder.toString())
                    startActivity(intent)
                }
            }
        }
    }

    override fun observerViewModel() {

    }
}