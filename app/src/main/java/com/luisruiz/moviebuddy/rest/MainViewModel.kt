package com.luisruiz.moviebuddy.rest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luisruiz.moviebuddy.model.Movie
import com.luisruiz.moviebuddy.model.NowPlaying
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    //LiveData for the Movie
    val movieLiveData = MutableLiveData<Movie>()

    // LiveData for Now Playing.
    val nowPlayingLiveData = MutableLiveData<NowPlaying>()

    private val repository: Repository = Repository()

    fun getMovie(id: String) {

        // Call for the desired Movie.
        val call: Call<Movie> = repository.getMovie(id)

        // Send the request.
        call.enqueue(object: Callback<Movie> {

            /**
             * Called if the network request is successful.
             */
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {

                // If the response is successful.
                if (response.isSuccessful) {


                    // Update the LiveData.
                    movieLiveData.value = response.body()

                } else { // If the response is unsuccessful.

                }
            }

            /**
             * Called if the network request fails.
             */
            override fun onFailure(call: Call<Movie>, t: Throwable) {
            }

        })
    }

    fun getNowPlaying() {

        // Call for Now Playing.
        val call: Call<NowPlaying> = repository.getNowPlaying()

        // Send the request.
        call.enqueue(object: Callback<NowPlaying> {

            /**
             * Called if the network request is successful.
             */
            override fun onResponse(call: Call<NowPlaying>, response: Response<NowPlaying>) {

                // If the response is successful.
                if (response.isSuccessful) {

                    // Update the LiveData.
                    nowPlayingLiveData.value = response.body()
                }
            }

            /**
             * Called if the network request fails.
             */
            override fun onFailure(call: Call<NowPlaying>, t: Throwable) {
            }

        })
    }

}