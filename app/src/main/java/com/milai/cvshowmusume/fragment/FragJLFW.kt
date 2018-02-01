package com.milai.cvshowmusume.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.milai.cvshowmusume.R

/**
 * Created by Administrator on 2018/1/8.
 *
 * 主要功能：
 */
class FragJLFW : Fragment() {
    var fragView: View? = null
    var listener: FragCZXZ.onBackListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as FragCZXZ.onBackListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (fragView == null) {
            fragView = inflater.inflate(R.layout.frag_jlfw, container, false)
        }
        return fragView
    }
}