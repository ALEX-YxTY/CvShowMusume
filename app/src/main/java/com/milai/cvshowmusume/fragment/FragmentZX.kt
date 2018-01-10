package com.milai.cvshowmusume.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.activity.GCDetailActivity
import com.milai.cvshowmusume.activity.ZXDetailActivity
import com.milai.cvshowmusume.adapter.OnPicClickListener
import com.milai.cvshowmusume.adapter.PicAdapter
import com.milai.cvshowmusume.bean.ZxDetail
import java.util.ArrayList

/**
 * Created by Administrator on 2018/1/8.
 *
 * 主要功能：
 */
class FragmentZX : Fragment(),OnPicClickListener {

    var fragView: View? = null
    var tvTitle: TextView? = null
    var tvZB: TextView? = null
    var tvCB: TextView? = null
    var tvTime: TextView? = null
    var vp: ViewPager? = null

    private val dataList:ArrayList<ZxDetail> by lazy { ArrayList<ZxDetail>() }
    private val picList:ArrayList<Int> by lazy { ArrayList<Int>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("test", "zx onCreate view")
        if (fragView == null) {
            fragView = inflater.inflate(R.layout.frag_zx, container, false)
            tvTitle = fragView?.findViewById(R.id.tv_title)
            tvZB = fragView?.findViewById(R.id.tv_zb)
            tvCB = fragView?.findViewById(R.id.tv_cb)
            tvTime = fragView?.findViewById(R.id.tv_time)
            vp = fragView?.findViewById(R.id.vp)
            initUI()
        }
        return fragView
    }

    private fun initUI() {
        //TODO 获取展讯数据
        dataList.add(ZxDetail("title1<br/>lalala","zb1","cb1","2018-1-2","",R.drawable.zx_1))
        dataList.add(ZxDetail("title2","zb2","cb2","2018-1-3","",R.drawable.zx_2))
        dataList.add(ZxDetail("title3","zb3","cb3","2018-1-4","",R.drawable.zx_3))
        dataList.add(ZxDetail("title4","zb4","cb4","2018-1-5","",R.drawable.zx_4))
        dataList.add(ZxDetail("title5","zb5","cb5","2018-1-6","",R.drawable.zx_5))
        dataList.mapTo(picList) { it.url }
        vp?.adapter = PicAdapter(this.activity!!, picList, this)
        vp?.pageMargin = 50
        vp?.offscreenPageLimit = 3
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
        val zxDetail = dataList[position]
        tvTitle?.text = Html.fromHtml(zxDetail.title)
        tvZB?.text = "主办单位："+ zxDetail.zb
        tvCB?.text = "承办单位：" + zxDetail.cb
        tvTime?.text = zxDetail.time
    }

    override fun onPicClick(index: Int) {
        val intent = Intent(activity, ZXDetailActivity::class.java)
        intent.putExtra("zx",dataList[index])
        startActivity(intent)
    }
}