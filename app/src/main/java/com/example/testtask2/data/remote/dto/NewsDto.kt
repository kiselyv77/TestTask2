package com.example.testtask2.data.remote.dto

data class NewsDto(

    val status:String = "",
    val totalResults: Int = 0,
    val articles:ArrayList<NewsDtoItem> = ArrayList<NewsDtoItem>(),

)