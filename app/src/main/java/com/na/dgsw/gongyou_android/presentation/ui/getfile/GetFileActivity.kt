package com.na.dgsw.gongyou_android.presentation.ui.getfile

import android.app.ProgressDialog
import android.os.Environment
import android.os.Environment.DIRECTORY_DOWNLOADS
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.firebase.storage.FirebaseStorage
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseActivity
import com.na.dgsw.gongyou_android.databinding.ActivityGetFileBinding
import java.io.File


/**
 * Created by NA on 2020-07-07
 * skehdgur8591@naver.com
 */
class GetFileActivity: BaseActivity<ActivityGetFileBinding, GetFileViewModel>(GetFileViewModel::class) {

    var getFileList = arrayListOf<String>()

    override val viewModelClass: Class<GetFileViewModel>
        get() = GetFileViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_get_file
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        getFileList = intent.extras!!.getStringArrayList("fileUri") as ArrayList<String>

        binding.fileSizeTextView.text = "선택한 파일 " + getFileList.size + "개를 받으시겠습니까?"
    }

    override fun observerViewModel() {
        with(viewModel) {
            getBtnClickEvent.observe(this@GetFileActivity, Observer {
                getFiles()
            })

            cancelBtnClickEvent.observe(this@GetFileActivity, Observer {

            })
        }
    }

    private fun getFiles() {
        for (i in 0..getFileList.size - 1) {
            val pos = getFileList.get(i).lastIndexOf("/")
            val fileName = getFileList.get(i).substring(pos + 1)


            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("다운로드 중 ...")
            progressDialog.show()

            val storage = FirebaseStorage.getInstance()
            val storageRef = storage.getReferenceFromUrl("gs://gongyou-c6aa9.appspot.com")
            val fileRef = storageRef.child(getFileList.get(i))

            val path = File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).toString())

            if (!path.exists()) {
                path.mkdirs()
            }

            val file = File(path, fileName)
            fileRef.getFile(file).addOnSuccessListener {
                if (i == getFileList.size - 1) {
                    Toast.makeText(applicationContext, "다운로드 완료! \n" + Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).toString(), Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                    finish()
                }
            }.addOnFailureListener {
                progressDialog.dismiss()
                Toast.makeText(this, "Firebase GET File Fail", Toast.LENGTH_SHORT).show()
            }.addOnProgressListener {
                val progress = (100 * it.bytesTransferred) / it.totalByteCount
                progressDialog.setMessage("Uploaded " + progress.toInt() + "% ...")
            }

        }

    }
}