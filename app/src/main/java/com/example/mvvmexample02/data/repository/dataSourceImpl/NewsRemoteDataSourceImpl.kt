package com.example.mvvmexample02.data.repository.dataSourceImpl

import com.example.mvvmexample02.data.api.NewsAPIService
import com.example.mvvmexample02.data.model.APIResponse
import com.example.mvvmexample02.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
) : NewsRemoteDataSource {
    override suspend fun getNewsHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getNewsHeadlines(country, page)
    }

    override suspend fun getSearchedNews(
        country: String,
        queryString: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedNewsHeadlines(country, queryString, page)
    }


}