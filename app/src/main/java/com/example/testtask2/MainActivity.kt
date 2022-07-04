package com.example.testtask2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask2.common.Resource
import com.example.testtask2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val viewModel: MainViewModel by viewModels()


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rcView = binding.rcView
        rcView.layoutManager  = LinearLayoutManager(this)

        viewModel.getNews().onEach{ result ->
            when (result){
                is Resource.Success -> {
                    val rcViewAdapter = RcViewAdapter(result.data!!)
                    rcView.adapter = rcViewAdapter
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(lifecycleScope)

    }
}