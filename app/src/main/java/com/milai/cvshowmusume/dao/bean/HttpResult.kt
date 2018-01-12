package com.milai.cvshowmusume.dao.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by Administrator on 2018/1/12.
 *
 * 主要功能：
 */
data class HttpResult<T>(
        @SerializedName("status") var status:Int
        ,@SerializedName("msg") var msg:String
        ,@SerializedName("data") var data:T){
    /**
     * Returns a string representation of the object.
     */
    override fun toString(): String {
        return "HttpResult: { status:" + status + ", msg:" + msg + ",data:" + data.toString() + "}"
    }
}