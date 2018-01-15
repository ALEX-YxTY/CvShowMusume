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
import android.widget.Toast
import com.milai.cvshowmusume.R
import com.milai.cvshowmusume.activity.ZXDetailActivity
import com.milai.cvshowmusume.adapter.OnPicClickListener
import com.milai.cvshowmusume.adapter.PicAdapter
import com.milai.cvshowmusume.adapter.PicTransformer
import com.milai.cvshowmusume.dao.HttpApiClient
import com.milai.cvshowmusume.dao.HttpResultFunc
import com.milai.cvshowmusume.dao.HttpRetrofit
import com.milai.cvshowmusume.dao.bean.ZxDetail
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
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

    val httpRetrofit:HttpRetrofit by lazy{ HttpApiClient.retrofit()}
    val disposal:CompositeDisposable by lazy { CompositeDisposable() }

    private val dataList:ArrayList<ZxDetail> by lazy { ArrayList<ZxDetail>() }
    private val picList:ArrayList<String> by lazy { ArrayList<String>() }

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
        httpRetrofit.getZXList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(HttpResultFunc())
                .subscribe({
                    //onNext
                    result:List<ZxDetail> ->
                    dataList.clear()
                    dataList.addAll(result)
                    dataList.mapTo(picList) { it.img }
                    vp?.adapter = PicAdapter(this.activity!!, picList, this)
                    vp?.setPageTransformer(true, PicTransformer())
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
                },{
                    //onError
                    e:Throwable ->
                    e.printStackTrace()
                    Toast.makeText(activity,"网络错误，请稍后重试",Toast.LENGTH_SHORT).show()
                },{
                    //onComplete
                },{
                    t: Disposable -> disposal.add(t)
                })
    }

    private fun showPosition(position: Int) {
        val zxDetail = dataList[position]
        tvTitle?.text = Html.fromHtml(zxDetail.title)
        tvZB?.text = "主办单位："+ zxDetail.zb_company
        tvCB?.text = "承办单位：" + zxDetail.cb_company
        tvTime?.text = zxDetail.time
    }

    override fun onPicClick(index: Int) {
        val intent = Intent(activity, ZXDetailActivity::class.java)
        intent.putExtra("zx",dataList[index])
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposal.clear()
    }
}