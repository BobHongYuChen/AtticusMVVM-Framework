package com.mysteryty.atticus.mvvm.state

import com.mysteryty.atticus.mvvm.bean.Wallpaper

/**
 * The page state
 *
 * @constructor Create empty Main state
 */
sealed class MainState {

    // Idle state
    object Idle: MainState()

    // Loading state
    object Loading: MainState()

    // Get wallpapers
    data class Wallpapers(val wallpaper: Wallpaper): MainState()

    // Wrong message
    data class Error(val error: String): MainState()
}