package com.example.mvvmexample02.data.repository.dataSource

import com.example.mvvmexample02.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getNewsHeadlines(country: String, page: Int): Response<APIResponse>

    suspend fun getSearchedNews(
        country: String,
        queryString: String,
        page: Int,
    ): Response<APIResponse>
}