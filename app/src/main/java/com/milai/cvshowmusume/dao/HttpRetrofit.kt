package com.milai.cvshowmusume.dao

import com.milai.cvshowmusume.dao.bean.GcjpDetail
import com.milai.cvshowmusume.dao.bean.HttpResult
import com.milai.cvshowmusume.dao.bean.ZxDetail
import io.reactivex.Observable
import retrofit2.http.POST

/**
 * Created by Administrator on 2018/1/12.
 *
 * 主要功能：
 */
interface HttpRetrofit {

    //获取馆藏列表
    @POST("Home/Index/guancang")
    fun getGCList(): Observable<HttpResult<List<GcjpDetail>>>


    //获取展讯列表
    @POST("Home/Index/zhanxun")
    fun getZXList(): Observable<HttpResult<List<ZxDetail>>>

}