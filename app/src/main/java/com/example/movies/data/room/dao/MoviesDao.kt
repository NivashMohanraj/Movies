package com.example.movies.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.models.MovieItemModel

interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(moviesItemModel: MovieItemModel)

    @Delete
    fun delete(moviesItemModel: MovieItemModel)

    @Query("SELECT * from movie_table")
    fun getAllMovies(): LiveData<List<MovieItemModel>>
}