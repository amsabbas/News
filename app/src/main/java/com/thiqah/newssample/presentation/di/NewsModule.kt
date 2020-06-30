package com.thiqah.newssample.presentation.di

import com.thiqah.newssample.base.utils.ServiceGenerator
import com.thiqah.newssample.data.repository.NewsRepositoryImpl
import com.thiqah.newssample.data.source.remote.NewsRemoteDataSource
import com.thiqah.newssample.data.source.remote.network.NewsApiService
import com.thiqah.newssample.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
object NewsModule {

    @Provides
    fun provideNewsRepository(
        remoteDataSource: NewsRemoteDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(
            remoteDataSource
        )
    }

    @Provides
    fun provideNewsApiService(
    ): NewsApiService {
        return ServiceGenerator()
            .createService(NewsApiService::class.java)
    }

}