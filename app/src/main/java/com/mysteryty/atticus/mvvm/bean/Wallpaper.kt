package com.mysteryty.atticus.mvvm.bean


import com.squareup.moshi.Json

data class Wallpaper(
    @Json(name = "code")
    val code: Int,
    @Json(name = "msg")
    val msg: String,
    @Json(name = "res")
    val res: Res
)