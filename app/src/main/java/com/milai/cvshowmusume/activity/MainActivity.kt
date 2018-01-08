package com.milai.cvshowmusume.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.ScrollView
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.adapter.FrontPageAdapter
import com.milai.cvshowmusume.custom.VerticalPageTransformer
import com.milai.cvshowmusume.custom.VerticalViewPager
import com.milai.cvshowmusume.fragment.FirstFragment
import com.milai.cvshowmusume.fragment.SecondFragment

class MainActivity : AppCompatActivity() {

    private val vp by lazy { findViewById<VerticalViewPager>(R.id.vp) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataList = ArrayList<Fragment>()
        dataList.add(FirstFragment())
        dataList.add(SecondFragment())
        vp.adapter = FrontPageAdapter(supportFragmentManager, dataList)
        // 修改
        vp.overScrollMode = ScrollView.OVER_SCROLL_NEVER
        vp.setPageTransformer(true, VerticalPageTransformer())


    }
}
