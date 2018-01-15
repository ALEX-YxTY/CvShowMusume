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
import com.milai.cvshowmusume.dao.bean.ZxDetail

class ZXDetailActivity : AppCompatActivity() {

    private val tvTitle: TextView by lazy{ findViewById<TextView>(R.id.tv_title)}
    private val wb: WebView by lazy{ findViewById<WebView>(R.id.wb)}

    private val iv: ImageView by lazy { findViewById<ImageView>(R.id.iv)}

    private val zx:ZxDetail by lazy { intent.getSerializableExtra("zx") as ZxDetail }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zx_detail)
        findViewById<TextView>(R.id.tv_back).setOnClickListener { onBackPressed() }
        findViewById<ImageView>(R.id.component5).setOnClickListener { startActivity(Intent(this,MainActivity::class.java)) }
        tvTitle.text = zx.title
        wb.webChromeClient = WebChromeClient()
        wb.webViewClient = WebViewClient()
        wb.loadUrl("http://meishuguan.domobile.net/home/Articie/zhanxun?id=" + zx.id)
        Glide.with(this).load(zx.img).into(iv)
        iv.setOnClickListener {
            val intent = Intent(this, PicDetailActivity::class.java)
            intent.putExtra("pic", zx.img)
            startActivity(intent)
        }
    }
}
