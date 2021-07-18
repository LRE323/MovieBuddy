package com.luisruiz.moviebuddy.model

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("title")
    val title: String,

)