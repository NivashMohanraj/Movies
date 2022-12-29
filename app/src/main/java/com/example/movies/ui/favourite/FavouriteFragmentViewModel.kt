package com.example.movies.ui.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movies.REALIZATION
import com.example.movies.models.MovieItemModel

class FavouriteFragmentViewModel : ViewModel() {


    fun getAllMovies(): LiveData<List<MovieItemModel>> {
        return REALIZATION.allMovies
    }
}