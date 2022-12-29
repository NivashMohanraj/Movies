package com.example.movies.data.room.repository

import androidx.lifecycle.LiveData
import com.example.movies.data.room.dao.MoviesDao
import com.example.movies.models.MovieItemModel

class MoviesRepositoryFactory (private val moviesDao: MoviesDao): MoviesRepository{
    override val allMovies: LiveData<List<MovieItemModel>>
        get() = moviesDao.getAllMovies()

    override suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.insert(movieItemModel)
        onSuccess()
    }

    override suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.delete(movieItemModel)
        onSuccess()
    }
}