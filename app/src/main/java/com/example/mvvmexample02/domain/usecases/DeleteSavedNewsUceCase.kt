package com.example.mvvmexample02.domain.usecases

import com.example.mvvmexample02.data.model.Article
import com.example.mvvmexample02.domain.repository.NewsRepository

class DeleteSavedNewsUceCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}