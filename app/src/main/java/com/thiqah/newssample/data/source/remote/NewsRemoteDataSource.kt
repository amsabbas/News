package com.thiqah.newssample.data.source.remote

import com.thiqah.newssample.data.source.remote.network.NewsApiService
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val service: NewsApiService) {
    fun getNews() = service.getNews()
}