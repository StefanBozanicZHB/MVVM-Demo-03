package com.example.mvvmexample02.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample02.domain.usecases.GetNewsHeadlinesUseCase
import com.example.mvvmexample02.domain.usecases.GetSearchedNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(app, getNewsHeadlinesUseCase, getSearchedNewsUseCase) as T
        }
        throw IllegalAccessException("Unknown View Model Class")
    }
}