package com.milai.cvshowmusume.dao.bean

import java.io.Serializable

/**
 * Created by Administrator on 2018/1/9.
 *
 * 主要功能：
 */
data class GcjpDetail(val id:Int, val title: String, val name: String, val address: String
                      , val content:String, val img: String, val status: Int, val orders:Int):Serializable