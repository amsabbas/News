package com.thiqah.newssample.domain.interactor

import com.thiqah.newssample.data.source.model.News
import com.thiqah.newssample.domain.repository.NewsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository: NewsRepository) {
    fun getNews(): Observable<List<News>> {
        return repository.getNews()
    }

}