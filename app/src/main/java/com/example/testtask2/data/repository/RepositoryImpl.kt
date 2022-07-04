package com.example.testtask2.data.repository

import com.example.testtask2.data.remote.NewsApi
import com.example.testtask2.data.remote.dto.NewsDto
import com.example.testtask2.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val api:NewsApi): Repository  {
    override suspend fun getNews(): NewsDto {
        return api.getNews()
    }
}