package com.milai.cvshowmusume.dao

import android.util.Log
import com.milai.cvshowmusume.dao.bean.HttpResult
import io.reactivex.functions.Function

/**
 * Created by Administrator on 2018/1/12.
 *
 * 主要功能：
 */
class HttpResultFunc<T>:Function<HttpResult<T>,T> {
    override fun apply(t: HttpResult<T>): T {
        Log.d("http", t.toString())
        if (t != null ) {
            if (t.status != 1) {
                throw RuntimeException(t.msg)
            } else {
                return t.data
            }
        } else {
            throw RuntimeException("获取网络信息失败")
        }
    }
}