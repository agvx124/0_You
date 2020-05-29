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
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.base.BaseActivity
import com.na.dgsw.gongyou_android.databinding.ActivitySendBinding
import com.na.dgsw.gongyou_android.view.main.MainActivity
import com.na.dgsw.gongyou_android.viewmodel.SendViewModel

class SendActivity : BaseActivity<ActivitySendBinding, SendViewModel>() {

    // 해당 파일 확장자 명
//    private var EXTENSION = ""

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
//        EXTENSION = intent.getStringExtra("extension")

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

    }

    private fun uploadFile(list: ArrayList<Uri>) {
        for (filePath in list) {
            var index = 1
            val progressDialog: ProgressDialog = ProgressDialog(this)
            progressDialog.setTitle("업로드 중 ...")
            progressDialog.show()

            val storage: FirebaseStorage = FirebaseStorage.getInstance()

            val randomNum = (0 .. 999999).random()

            // 파일 확장자 구하기
            val pos = filePath.path!!.lastIndexOf(".")
            val ext = filePath.path!!.substring(pos + 1)
            // 랜덤 숫자로 파일이름 부여
            val fileName = randomNum.toString() + "." + ext

            val storageReference: StorageReference = storage.getReferenceFromUrl("gs://gongyou-c6aa9.appspot.com").child(ext + "/" + fileName)

            storageReference.putFile(Uri.parse("file://" + filePath.path))
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(this, "업로드 완료", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    progressDialog.dismiss()
                    Toast.makeText(this, "업로드 실패", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot: UploadTask.TaskSnapshot ->
                    @SuppressWarnings("VisibleForTests")
                    val progress = (100 * taskSnapshot.bytesTransferred) / taskSnapshot.totalByteCount
                    progressDialog.setMessage("Uploaded " + progress.toInt() + "% ...")
                }
        }
    }
}
