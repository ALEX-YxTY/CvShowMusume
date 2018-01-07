package com.milai.cvshowmusume.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.custom.VerticalViewPager

class MainActivity : AppCompatActivity() {

    private val vp by lazy { findViewById<VerticalViewPager>(R.id.vp) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 修改
//        vp.overScrollMode = ScrollView.OVER_SCROLL_NEVER
//        vp.setPageTransformer(true, VerticalPageTransformer())


    }
}
