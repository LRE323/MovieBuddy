package com.luisruiz.moviebuddy.model

import com.google.gson.annotations.SerializedName

data class NowPlaying(

    @SerializedName("results")
    val results: List<Movie>
) {

}