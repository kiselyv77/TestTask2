package com.example.testtask2

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testtask2.common.Resource
import com.example.testtask2.data.remote.dto.NewsDto
import com.example.testtask2.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: Repository

): ViewModel() {

     fun getNews(): Flow<Resource<NewsDto>> = flow{
        try{
            emit(Resource.Loading<NewsDto>())
            val coutries = repository.getNews()
            Log.d("get", "${coutries.totalResults}")
            emit(Resource.Success<NewsDto>(data = coutries))
        } catch (e: HttpException){
            emit(Resource.Error<NewsDto>(e.localizedMessage?: "unexpected error"))
        }catch (e: IOException){
            emit(Resource.Error<NewsDto>(e.localizedMessage?: "not enternet"))
        }

    }
}

