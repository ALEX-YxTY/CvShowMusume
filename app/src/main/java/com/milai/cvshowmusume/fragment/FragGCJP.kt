package com.milai.cvshowmusume.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.activity.GCDetailActivity
import com.milai.cvshowmusume.adapter.OnPicClickListener
import com.milai.cvshowmusume.adapter.PicAdapter
import com.milai.cvshowmusume.adapter.PicTransformer
import com.milai.cvshowmusume.bean.GcjpDetail
import java.util.ArrayList

/**
 * Created by Administrator on 2018/1/8.
 *
 * 主要功能：
 */
class FragGCJP:Fragment(),OnPicClickListener {

    var fragView: View? = null
    var tvTitle: TextView? = null
    var tvName: TextView? = null
    var tvAdd: TextView? = null
    var vp: ViewPager? = null

    private val dataList: ArrayList<GcjpDetail> by lazy { ArrayList<GcjpDetail>() }
    private val picList: ArrayList<Int> by lazy { ArrayList<Int>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (fragView == null) {
            fragView = inflater.inflate(R.layout.frag_gcjp, container, false)
            tvTitle = fragView?.findViewById(R.id.tv_title)
            tvName = fragView?.findViewById(R.id.tv_name)
            tvAdd = fragView?.findViewById(R.id.tv_address)
            vp = fragView?.findViewById(R.id.vp)
            initUI()
        }
        return fragView
    }

    private fun initUI() {
        //TODO 获取展讯数据
        dataList.add(GcjpDetail("title1asfsdf","name1","add1","",R.drawable.gc_1))
        dataList.add(GcjpDetail("title2","name2","add2","",R.drawable.gc_2))
        dataList.add(GcjpDetail("title3","name3","add3","",R.drawable.gc_3))
        dataList.add(GcjpDetail("title4","name4","add4","",R.drawable.gc_4))
        dataList.add(GcjpDetail("title5","name5","add5","",R.drawable.gc_5))
        dataList.add(GcjpDetail("title6","name6","add6","",R.drawable.gc_6))
        dataList.add(GcjpDetail("title7","name7","add7","",R.drawable.gc_7))
        dataList.add(GcjpDetail("title8","name8","add8","",R.drawable.gc_8))
        dataList.add(GcjpDetail("title9","name9","add9","",R.drawable.gc_9))
        dataList.add(GcjpDetail("title10","name10","add10","",R.drawable.gc_10))

        dataList.mapTo(picList) { it.url }
        vp?.adapter = PicAdapter(this.activity!!, picList, this)
        vp?.pageMargin = 40
        vp?.setPageTransformer(true,PicTransformer())
        vp?.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                showPosition(position)
            }
        })
        vp?.currentItem = 0
        showPosition(0)
    }

    private fun showPosition(position: Int) {
        val gcDetail = dataList[position]
        tvTitle?.text = Html.fromHtml("《"+gcDetail.title+"》")
        tvName?.text = gcDetail.name
        tvAdd?.text = gcDetail.add
    }

    override fun onPicClick(index: Int) {
        val intent = Intent(activity, GCDetailActivity::class.java)
        intent.putExtra("gc",dataList[index])
        startActivity(intent)
    }
}