package com.milai.cvshowmusume.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.activity.InsideActivity

/**
 * Created by Administrator on 2018/1/8.
 *
 * 主要功能：
 */
class SecondFragment : Fragment(),View.OnClickListener {

    private var fragView:View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (fragView == null) {
            fragView = inflater!!.inflate(R.layout.frag_second, container, false)
            fragView?.findViewById<Button>(R.id.bt_gcjp)?.setOnClickListener(this)
            val btZx = fragView?.findViewById<Button>(R.id.bt_zx)
            btZx?.text = Html.fromHtml("展&#12288;&#12288;讯")
            btZx?.setOnClickListener(this)
            fragView?.findViewById<Button>(R.id.bt_bzxz)?.setOnClickListener(this)
            fragView?.findViewById<Button>(R.id.bt_zxzl)?.setOnClickListener(this)
            fragView?.findViewById<Button>(R.id.bt_jlfw)?.setOnClickListener(this)
        }
        return fragView
    }

    override fun onClick(view: View?) {
        var intent = Intent(activity, InsideActivity::class.java)
        when (view?.id) {
            R.id.bt_gcjp ->{
                //馆藏精品
                intent.putExtra("select", 1)
            }
            R.id.bt_zx ->{
                //展讯
                intent.putExtra("select", 0)
            }
            R.id.bt_bzxz ->{
                //办展须知
                intent.putExtra("select", 2)
            }
            R.id.bt_zxzl ->{
                //在线展览
                intent.putExtra("select", 3)
            }
            R.id.bt_jlfw ->{
                //交流服务
                intent.putExtra("select", 4)
            }
        }
        activity?.startActivity(intent)
    }
}