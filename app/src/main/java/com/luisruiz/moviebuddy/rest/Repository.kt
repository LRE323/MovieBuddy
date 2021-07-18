package com.luisruiz.moviebuddy.rest

import com.luisruiz.moviebuddy.model.Movie
import com.luisruiz.moviebuddy.model.NowPlaying
import retrofit2.Call
import retrofit2.Retrofit

class Repository {

    // The instance of Retrofit.
    private val retrofit: Retrofit = APIClient.retrofit

    // Create the instance of the Retrofit service.
    private val retrofitService: RetrofitService = retrofit.create(RetrofitService::class.java)

    fun getMovie(id: String): Call<Movie> {
        return retrofitService.getMovie(id)
    }

    fun getNowPlaying(): Call<NowPlaying> {
        return retrofitService.getNowPlaying()
    }
}