package com.milai.cvshowmusume.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.bean.ZxDetail

class ZXDetailActivity : AppCompatActivity() {

    private val tvTitle: TextView by lazy{ findViewById<TextView>(R.id.tv_title)}
    private val tvDetail: TextView by lazy{ findViewById<TextView>(R.id.tv_detail)}
    private val iv: ImageView by lazy { findViewById<ImageView>(R.id.iv)}

    private val zx:ZxDetail by lazy { intent.getSerializableExtra("zx") as ZxDetail }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zx_detail)
        findViewById<TextView>(R.id.tv_back).setOnClickListener { onBackPressed() }
        tvTitle.text = zx.title
        tvDetail.text = Html.fromHtml(zx.detail)
        Glide.with(this).load(zx.url).into(iv)
    }
}
