package com.mysteryty.atticus.mvvm.network

import com.mysteryty.atticus.mvvm.inter.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkUtils {

    private const val BASE_URL = "http://service.picasso.adesk.com/"

    /**
     * Format json to data class by moshi
     */
    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    /**
     * Build retrofit class
     */
    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    /**
     * Create API server request
     */
    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}