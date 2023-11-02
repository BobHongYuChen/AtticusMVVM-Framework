package com.mysteryty.atticus.mvvm.ui.adapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mysteryty.atticus.mvvm.intent.MainIntent
import com.mysteryty.atticus.mvvm.viewmodel.repository.MainRepository
import com.mysteryty.atticus.mvvm.state.MainState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.io.Closeable

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    // main intent channel, it's channel is unlimited
    val mainIntentChannel = Channel<MainIntent>(Channel.UNLIMITED)

    // state flow
    private val _state = MutableStateFlow<MainState>(MainState.Idle)

    // state flow observer
    val state: StateFlow<MainState> get() = _state

    init {
        viewModelScope.launch {
            // collect intent
            mainIntentChannel.consumeAsFlow().collect() {
                when (it) {
                    // intent is get wallpapers
                    is MainIntent.GetWallpaper -> getWallpaper()
                }
            }
        }
    }

    private fun getWallpaper() {
        viewModelScope.launch {
            // change state to loading
            _state.value = MainState.Loading
            // send network request
            _state.value = try {
                // Request success
                MainState.Wallpapers(repository.getWallpaper())
            } catch (e: Exception) {
                // Request failed
                MainState.Error(e.localizedMessage ?: "UnKnown Error")
            }
        }
    }

}