package com.mysteryty.atticus.mvvm.viewmodel.repository

import com.mysteryty.atticus.mvvm.inter.ApiService

/**
 * View Model for UI
 *
 * @constructor Create empty Main repository
 */
class MainRepository(private val apiService: ApiService) {

    /**
     * get wallpapers
     */
    suspend fun getWallpaper() = apiService.getWallpaper()
}