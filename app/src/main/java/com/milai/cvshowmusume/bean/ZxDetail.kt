package com.milai.cvshowmusume.bean

import android.support.annotation.IntegerRes
import java.io.Serializable

/**
 * Created by Administrator on 2018/1/9.
 *
 * 主要功能：
 */
data class ZxDetail(val title: String, val zb: String, val cb: String, val time: String, val detail:String, val url: Int):Serializable
