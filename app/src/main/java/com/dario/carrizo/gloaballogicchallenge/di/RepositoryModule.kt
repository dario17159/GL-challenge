package com.dario.carrizo.gloaballogicchallenge.di

import com.dario.carrizo.gloaballogicchallenge.data.ApiRepositoryImplementation
import com.dario.carrizo.gloaballogicchallenge.data.remote.ApiClient
import com.dario.carrizo.gloaballogicchallenge.data.remote.ApiService
import com.dario.carrizo.gloaballogicchallenge.domain.repositories.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Dario Carrizo on 01/06/2022
 **/
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideApiRepository(apiService: ApiService): ApiRepository = ApiRepositoryImplementation(apiService)
}