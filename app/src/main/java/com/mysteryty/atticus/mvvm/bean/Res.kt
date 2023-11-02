package com.mysteryty.atticus.mvvm.bean


import com.squareup.moshi.Json

data class Res(
    @Json(name = "vertical")
    val vertical: List<Vertical>
)