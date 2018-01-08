package com.milai.cvshowmusume.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.text.Html
import android.util.Log
import android.widget.FrameLayout
import android.widget.TextView
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.fragment.FragmentZX

class InsideActivity : AppCompatActivity() {

    private val tabLayout: TabLayout by lazy{ findViewById<TabLayout>(R.id.tabLayout) }
    private val fragZX : Fragment by lazy{ FragmentZX()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside)
        val nameList = listOf("首&#12288;页","展&#12288;讯", "馆&#160;藏&#160;精&#160;品", "观&#160;展&#160;须&#160;知")
        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
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
            tabLayout.addTab(tab, it, it == 1)
        }
        supportFragmentManager.beginTransaction().add(R.id.frame, fragZX).commit()
    }

    private fun showTab(tab:TabLayout.Tab?) {
        var transaction: FragmentTransaction? = null
        when (tab?.position) {
            0 -> {onBackPressed()}
            1 -> {
                //展讯
                transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, fragZX)
            }
            2 -> {
                //馆藏精品
                transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, fragZX)

            }
            3 -> {
                //观展须知

            }
        }
        if (transaction != null) {
            transaction.commit()
        }
    }
}
