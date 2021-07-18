package com.luisruiz.moviebuddy.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    // The Move Database API base URL.
    private const val BASE_URL = "https://api.themoviedb.org"

    // The Gson converter for Retrofit.
    private val gsonConverter: GsonConverterFactory = GsonConverterFactory.create()

    // The instance of Retrofit.
    val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(gsonConverter).build()
}