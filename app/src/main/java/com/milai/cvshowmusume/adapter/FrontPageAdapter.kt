package com.milai.cvshowmusume.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Administrator on 2018/a/7.
 *
 * 功能介绍：
 */
class FrontPageAdapter(fm: FragmentManager?, private val dataList:List<Fragment>) : FragmentPagerAdapter(fm) {

    /**
     * Return the Fragment associated with a specified position.
     */
    override fun getItem(position: Int): Fragment {
        return dataList[position]
    }

    /**
     * Return the number of views available.
     */
    override fun getCount(): Int {
        return dataList.size
    }

}