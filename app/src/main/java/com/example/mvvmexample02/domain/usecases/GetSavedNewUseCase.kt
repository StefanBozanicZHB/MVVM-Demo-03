package com.example.mvvmexample02.domain.usecases

import com.example.mvvmexample02.data.model.Article
import com.example.mvvmexample02.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}