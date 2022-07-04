package com.example.testtask2.data.remote

import com.example.testtask2.data.remote.dto.NewsDto
import retrofit2.http.GET

interface NewsApi {

    @GET("https://newsapi.org/v2/everything?q=bitcoin&apiKey=8f0047a52975437e90a58918c4fa2dc2")
    suspend fun getNews(): NewsDto


}