package com.example.mvvmexample02.domain.usecases

import com.example.mvvmexample02.data.model.APIResponse
import com.example.mvvmexample02.data.util.Resource
import com.example.mvvmexample02.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, searchQuery: String, page: Int): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }
}