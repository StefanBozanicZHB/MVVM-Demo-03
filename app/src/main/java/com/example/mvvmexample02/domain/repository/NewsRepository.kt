package com.example.mvvmexample02.domain.repository

import com.example.mvvmexample02.data.model.APIResponse
import com.example.mvvmexample02.data.model.Article
import com.example.mvvmexample02.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNews(country: String, searchQuery: String, page: Int) : Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun  deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}