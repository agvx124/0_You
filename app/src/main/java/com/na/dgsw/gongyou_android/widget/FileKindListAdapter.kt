package com.na.dgsw.gongyou_android.widget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.data.FileKind


/**
 * Created by NA on 2020-05-21
 * skehdgur8591@naver.com
 */
class FileKindListAdapter (val context: Context, val fileKindList: ArrayList<FileKind>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.file_kind_list_item, null)

        val photo = view.findViewById<ImageView>(R.id.kind_img)
        val title = view.findViewById<TextView>(R.id.kind_textView)

        val file = fileKindList[position]
        val resourceId = context.resources.getIdentifier(file.photo, "drawable", context.packageName)


        photo.setImageResource(resourceId)
        title.text = file.name

        return view
    }

    override fun getItem(position: Int): Any {
        return fileKindList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return fileKindList.size
    }

}