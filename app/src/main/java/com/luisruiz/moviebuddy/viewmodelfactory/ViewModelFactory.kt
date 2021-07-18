package com.luisruiz.moviebuddy.viewmodelfactory

import androidx.lifecycle.ViewModelProvider
import com.luisruiz.moviebuddy.rest.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory: ViewModelProvider.Factory {

    override fun <T : androidx.lifecycle.ViewModel?> create(modelClass: Class<T>): T {

        // If modelClass is a MainViewModel
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return com.luisruiz.moviebuddy.rest.MainViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}