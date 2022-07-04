package com.example.testtask2.di

import com.example.testtask2.common.Constants.BASE_URL
import com.example.testtask2.data.remote.NewsApi
import com.example.testtask2.data.repository.RepositoryImpl
import com.example.testtask2.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCovidApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRepository(api:NewsApi): Repository {
        return RepositoryImpl(api)
    }

}