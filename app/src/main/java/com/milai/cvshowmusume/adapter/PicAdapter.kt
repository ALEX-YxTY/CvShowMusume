package com.milai.cvshowmusume.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.milai.cvshowmusume.R

/**
 * Created by Administrator on 2018/1/9.
 *
 * 主要功能：
 */
class PicAdapter(val ctx:Context, val dataList:List<String>, val listener:OnPicClickListener ):PagerAdapter() {

    private val glide:RequestManager by lazy { Glide.with(ctx) }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = View.inflate(ctx, R.layout.item_pic, null)
        val iv = view.findViewById<ImageView>(R.id.iv_main)
        iv.setOnClickListener { listener.onPicClick(position) }
        glide.load(dataList[position]).into(iv)
        //切记不要忘了加入container
        container.addView(view)
        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun getCount(): Int {
        return dataList.size
    }

}