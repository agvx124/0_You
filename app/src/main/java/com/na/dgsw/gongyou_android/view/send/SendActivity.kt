package com.na.dgsw.gongyou_android.view.send

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.data.network.request.FileRequest
import com.na.dgsw.gongyou_android.databinding.ActivitySendBinding
import com.na.dgsw.gongyou_android.view.main.MainActivity
import com.na.dgsw.gongyou_android.viewmodel.SendViewModel

class SendActivity : BaseActivity<ActivitySendBinding, SendViewModel>() {

    private val userSaveNum = (0 .. 9999999).random()

    override val viewModelClass: Class<SendViewModel>
        get() = SendViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_send
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
        val intent = intent
        val dataUrls = intent.getStringExtra("dataUrl")

        val arrayUriIndex: ArrayList<String> = dataUrls.split("\n") as ArrayList<String>
        // "" null Check
        for (fileUrl in arrayUriIndex) {
            if (fileUrl == "") arrayUriIndex.remove("")
        }

        val arrayUri: ArrayList<Uri> = ArrayList()

        for (fileUri in arrayUriIndex) {
            arrayUri.add(Uri.parse(fileUri))
        }

        binding.fileSizeTextView.text = "선택한 파일 " + arrayUriIndex.size + "개를 보내겠습니까?"

        binding.sendBtn.setOnClickListener {
            uploadFile(arrayUri)
        }

        binding.cancelBtn.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("보내기 취소")
            builder.setMessage("파일 보내기를 취소하시겠습니까?")
            builder.setPositiveButton("아니오") { dialog, which ->

            }
            builder.setNegativeButton("예") { dialog, which ->
                startActivity(Intent(this, MainActivity::class.java))
            }.show()
        }

    }

    override fun observerViewModel() {
        with(viewModel) {
            onSuccessEvent.observe(this@SendActivity, Observer {
                Toast.makeText(this@SendActivity, "파일 업로드에 성공하셨습니다.", Toast.LENGTH_SHORT).show()
            })

            onErrorEvent.observe(this@SendActivity, Observer {
                Toast.makeText(this@SendActivity, it.message, Toast.LENGTH_SHORT).show()
            })

        }
    }

    private fun uploadFile(list: ArrayList<Uri>) {
        for (filePath in list) {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("업로드 중 ...")
            progressDialog.show()

            val storage: FirebaseStorage = FirebaseStorage.getInstance()

            // 파일 확장자 구하기
            val pos = filePath.path!!.lastIndexOf(".")
            val ext = filePath.path!!.substring(pos + 1)

            val randomNum = (0 .. 9999999).random()
            val fileName = "$randomNum.$ext"

            val storageReference: StorageReference = storage.getReferenceFromUrl("gs://gongyou-c6aa9.appspot.com").child(
                "$ext/$fileName"
            )

            storageReference.putFile(Uri.parse("file://" + filePath.path))
                .addOnSuccessListener {
                    viewModel.postUrlUpload(FileRequest("agvx124", userSaveNum, fileName, list.size, ext))
                    progressDialog.dismiss()
//                    Toast.makeText(this, "업로드 완료", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                }
                .addOnFailureListener {
                    progressDialog.dismiss()
                    Toast.makeText(this, "Firebase Upload Fail, Restart", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot: UploadTask.TaskSnapshot ->
                    @SuppressWarnings("VisibleForTests")
                    val progress = (100 * taskSnapshot.bytesTransferred) / taskSnapshot.totalByteCount
                    progressDialog.setMessage("Uploaded " + progress.toInt() + "% ...")
                }
        }
    }
}
