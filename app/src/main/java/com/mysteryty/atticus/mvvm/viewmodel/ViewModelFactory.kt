package com.mysteryty.atticus.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mysteryty.atticus.mvvm.inter.ApiService
import com.mysteryty.atticus.mvvm.ui.adapter.MainViewModel
import com.mysteryty.atticus.mvvm.viewmodel.repository.MainRepository

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // judge MainViewModel is super class for ModeClass
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository((apiService))) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}