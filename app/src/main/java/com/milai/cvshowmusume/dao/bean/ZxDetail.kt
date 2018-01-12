package com.milai.cvshowmusume.dao.bean

import java.io.Serializable
import java.sql.ClientInfoStatus

/**
 * Created by Administrator on 2018/1/9.
 *
 * 主要功能：
 */
data class ZxDetail(val id:Int, val title: String, val zb_company: String, val cb_company: String
                    , val time: String, val content:String, val img: String, val status: Int, val orders:Int):Serializable
