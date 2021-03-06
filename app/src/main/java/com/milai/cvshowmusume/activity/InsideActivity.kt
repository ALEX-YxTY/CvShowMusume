package com.milai.cvshowmusume.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.text.Html
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.fragment.*

class InsideActivity : AppCompatActivity(), FragCZXZ.onBackListener {

    private val tabLayout: TabLayout by lazy { findViewById<TabLayout>(R.id.tabLayout) }
    private val fragZX: Fragment by lazy { FragmentZX() }
    private val fragGCJP: Fragment by lazy { FragGCJP() }
    private val fragCZXZ: Fragment by lazy { FragCZXZ() }
    private val fragZXZL: Fragment by lazy { FragZXZL() }
    private val fragJLFW: Fragment by lazy { FragJLFW() }

    private val select: Int by lazy { intent.getIntExtra("select", 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside)
        findViewById<ImageView>(R.id.component5).setOnClickListener { onBackPressed() }
        val nameList = listOf("首&#12288;页", "展&#12288;讯", "馆&#160;藏&#160;精&#160;品", "办&#160;展&#160;须&#160;知"
                , "在&#160;线&#160;展&#160;览", "交&#160;流&#160;服&#160;务")
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                showTab(tab)
            }

        })
        for (it: Int in 0 until nameList.size) {
            val tab = tabLayout.newTab()
            tab?.setCustomView(R.layout.item_tab)
            val textView: TextView? = tab?.customView?.findViewById(R.id.tv_tab)
            textView?.text = Html.fromHtml(nameList[it])
            tabLayout.addTab(tab, it, it == select + 1)
        }
    }

    private fun showTab(tab: TabLayout.Tab?) {
        var transaction: FragmentTransaction? = null
        when (tab?.position) {
            0 -> {
                onBackPressed()
            }
            1 -> {
                //展讯
                transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, fragZX)
            }
            2 -> {
                //馆藏精品
                transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, fragGCJP)

            }
            3 -> {
                //观展须知
                transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, fragCZXZ)
            }
            4 -> {
                //在线展览
                transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, fragZXZL)
            }
            5 -> {
                //观展须知
                transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, fragJLFW)
            }
        }
        if (transaction != null) {
            transaction.commit()
        }
    }

    override fun onBackPress() {
        onBackPressed()
    }
}
