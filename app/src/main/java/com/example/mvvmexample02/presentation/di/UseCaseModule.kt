package com.example.mvvmexample02.presentation.di

import com.example.mvvmexample02.domain.repository.NewsRepository
import com.example.mvvmexample02.domain.usecases.GetNewsHeadlinesUseCase
import com.example.mvvmexample02.domain.usecases.GetSearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsHeadlinesUseCase(
        newsRepository: NewsRepository,
    ): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedNewsUseCase(
        newsRepository: NewsRepository,
    ): GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }
}