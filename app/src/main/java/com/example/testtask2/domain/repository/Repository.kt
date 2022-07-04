package com.example.testtask2.domain.repository

import com.example.testtask2.data.remote.dto.NewsDto

interface Repository {
    suspend fun getNews(): NewsDto
}