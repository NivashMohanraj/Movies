package com.example.movies.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movies.REALIZATION
import com.example.movies.data.retrofit.api.RetrofitRepository
import com.example.movies.data.room.MoviesRoomDatabase
import com.example.movies.data.room.repository.MoviesRepositoryFactory
import com.example.movies.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel (application: Application): AndroidViewModel(application) {
    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()
    val context = application
    fun getMoviesRetrofit() {
        viewModelScope.launch {
            myMovies.value = repository.getMovie()
        }
    }

    fun initDatabase() {
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        REALIZATION = MoviesRepositoryFactory(daoMovie)

    }


}