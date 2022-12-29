package com.example.movies.data.retrofit.api

import com.example.movies.models.MoviesModel
import retrofit2.Response

class RetrofitRepository {

    suspend fun getMovie(): Response<MoviesModel> {
        return RetrofitInstance.api.getPopularMovie()
    }
}