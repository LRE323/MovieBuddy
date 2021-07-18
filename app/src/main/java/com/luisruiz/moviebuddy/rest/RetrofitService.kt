package com.luisruiz.moviebuddy.rest

import com.luisruiz.moviebuddy.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// The API key.
private const val apiKey: String = "bb3a03020d4260bd90c93e3d2f430b58"

interface RetrofitService {

    /**
     * Gets a the movie specified by ID from the API.
     */
    @GET("/3/movie/{id}?api_key=$apiKey")
    fun getMovie(@Path("id") id: String): Call<Movie>

    
}