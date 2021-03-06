package com.milai.cvshowmusume.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.dao.bean.GcjpDetail

class GCDetailActivity : AppCompatActivity() {

    private val tvTitle:TextView by lazy{ findViewById<TextView>(R.id.tv_title)}
    private val tvName:TextView by lazy{ findViewById<TextView>(R.id.tv_name)}
    private val wb:WebView by lazy{ findViewById<WebView>(R.id.wb)}
    private val iv:ImageView by lazy { findViewById<ImageView>(R.id.iv)}

    private val gcDetail:GcjpDetail by lazy{ intent.getSerializableExtra("gc") as GcjpDetail}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gc_detail)
        findViewById<TextView>(R.id.tv_back).setOnClickListener { onBackPressed() }
        findViewById<ImageView>(R.id.component5).setOnClickListener { startActivity(Intent(this,MainActivity::class.java)) }
        tvTitle.text = gcDetail.title
        tvName.text = gcDetail.name
        wb.webChromeClient = WebChromeClient()
        wb.webViewClient = WebViewClient()
        wb.loadUrl("http://meishuguan.domobile.net/home/Articie/guancang?id=" + gcDetail.id)
        Glide.with(this).load(gcDetail.img).into(iv)
        iv.setOnClickListener {
            val intent = Intent(this, PicDetailActivity::class.java)
            intent.putExtra("pic", gcDetail.img)
            startActivity(intent)
        }
    }
}
