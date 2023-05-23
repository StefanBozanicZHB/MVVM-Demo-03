package com.example.mvvmexample02.presentation.di

import android.app.Application
import com.example.mvvmexample02.domain.usecases.GetNewsHeadlinesUseCase
import com.example.mvvmexample02.domain.usecases.GetSearchedNewsUseCase
import com.example.mvvmexample02.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        app: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
    ): NewsViewModelFactory {
        return NewsViewModelFactory(app, getNewsHeadlinesUseCase, getSearchedNewsUseCase)
    }
}