package com.milai.cvshowmusume.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.milai.cvshowmusume.R

/**
 * Created by Administrator on 2018/a/7.
 *
 * 功能介绍：
 */
class FirstFragment: Fragment() {

    var fragView: View? = null
    var iv: ImageView? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (fragView == null) {
            fragView = inflater!!.inflate(R.layout.frag_first, container, false)
            iv = fragView?.findViewById(R.id.iv)

        }
        return fragView
    }
}