package com.thiqah.newssample.data.source.remote.network

import com.thiqah.newssample.data.source.model.News
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsApiService {

    @GET("v3/e53866cf-c439-4a4e-97e8-fa6ad4243706")
    fun getNews(): Observable<List<News>>

}