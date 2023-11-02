package com.mysteryty.atticus.mvvm.inter

import com.mysteryty.atticus.mvvm.bean.Wallpaper
import retrofit2.http.GET

interface ApiService {
    /*
     * get wallpapers from server
     */
    @GET("v1/vertical/vertical?limit=30&skip=180&adult=false&first=0&order=hot")
    suspend fun getWallpaper(): Wallpaper
}