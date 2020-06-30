package com.thiqah.newssample.domain.repository

import com.thiqah.newssample.data.source.model.News
import io.reactivex.Observable

interface NewsRepository {
    fun getNews(): Observable<List<News>>
}