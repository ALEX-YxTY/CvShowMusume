package com.milai.cvshowmusume.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.milai.cvshowmusume.R

/**
 * Created by Administrator on 2018/1/8.
 *
 * 主要功能：
 */
class FragCZXZ : Fragment() {
    var fragView: View? = null
    var listener: onBackListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as onBackListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (fragView == null) {
            fragView = inflater.inflate(R.layout.frag_czxz, container, false)
            fragView?.findViewById<View>(R.id.tv_back)?.setOnClickListener{ listener?.onBackPress()}
            val tv3 = fragView?.findViewById<TextView>(R.id.component3)
            tv3?.text = "南京美术馆场馆硬件设施：\n" +
                    "占地面积：800平方米；展厅面积：480平方米；\n" +
                    "展厅展线：180米；展厅高度：3.1米；\n" +
                    "展板数量：82块（每块标宽1米，净高3.1米"
            val tv4 = fragView?.findViewById<TextView>(R.id.component4)
            tv4?.text = "南京美术馆广告宣传品制作尺寸：\n" +
                    "户外横幅：10米X0.9米；大厅展板：2.4米X2.4米；\n" +
                    "大厅海报架：1米X2米；展厅横幅：3.8米X0.7米；\n" +
                    "展览前言：2.4米X0.9米"
        }
        return fragView
    }

    interface onBackListener{
        fun onBackPress()
    }
}