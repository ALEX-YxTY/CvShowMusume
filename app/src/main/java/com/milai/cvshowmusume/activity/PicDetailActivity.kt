package com.milai.cvshowmusume.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.milai.cvshowmusume.R

class PicDetailActivity : AppCompatActivity() {

    private val main:RelativeLayout by lazy{ findViewById<RelativeLayout>(R.id.main)}
    private val ivPic:ImageView by lazy { findViewById<ImageView>(R.id.iv_pic) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic_detail)
        Glide.with(this).load(intent.getStringExtra("pic")).into(ivPic)
        main.setOnClickListener { onBackPressed() }
        ivPic.setOnClickListener{ onBackPressed() }
    }
}
