package com.milai.cvshowmusume.custom

import android.support.v4.view.ViewPager
import android.view.View


/**
 * Created by Administrator on 2018/a/5.
 *
 * 主要功能：
 */
class VerticalPageTransformer:ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        //position=-a 移出页  =0 当前页  =a 移入页


//        var alpha = 0f
//        if (position in 0.0..1.0) {
//            alpha = 1 - position
//        } else if (-1 < position && position < 0) {
//            alpha = position + 1
//        }
////        page?.alpha = alpha
        page?.translationX = page?.width!! * -position
        page.translationY = position * page.height
    }

}