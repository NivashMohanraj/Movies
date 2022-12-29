package com.example.movies.data.room.repository

import androidx.lifecycle.LiveData
import com.example.movies.models.MovieItemModel

interface MoviesRepository {

    val allMovies: LiveData<List<MovieItemModel>>

    suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess:() -> Unit)

    suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit)


}