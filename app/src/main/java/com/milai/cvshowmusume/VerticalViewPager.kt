package com.milai.cvshowmusume

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by Administrator on 2018/1/5.
 *
 * 主要功能：纵向滚动Viewpager
 * 修改touchEvent的x,y坐标，使其会换（要根据宽高乘以相应比例，以免超出边界）
 * 重写onInterceptTouchEvent和onTouchEvent
 */
class VerticalViewPager : ViewPager {

    private val ratio by lazy { width/height }

    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attributes: AttributeSet) : super(ctx, attributes)

    fun swapEvnent(ev: MotionEvent?): MotionEvent? {
        ev?.setLocation(ev.y * ratio, ev.x / ratio)
        return ev
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(swapEvnent(MotionEvent.obtain(ev)))
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return super.onTouchEvent(swapEvnent(MotionEvent.obtain(ev)))
    }
}