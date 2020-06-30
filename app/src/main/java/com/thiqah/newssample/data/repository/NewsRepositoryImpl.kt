package com.thiqah.newssample.data.repository

import com.thiqah.newssample.data.source.model.News
import com.thiqah.newssample.data.source.remote.NewsRemoteDataSource
import com.thiqah.newssample.domain.repository.NewsRepository
import io.reactivex.Observable

class NewsRepositoryImpl constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource
) :
    NewsRepository {

    override fun getNews(): Observable<List<News>> {
        return newsRemoteDataSource.getNews()
    }
}