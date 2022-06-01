package com.dario.carrizo.gloaballogicchallenge.data

import androidx.lifecycle.MutableLiveData
import com.dario.carrizo.gloaballogicchallenge.data.model.Products
import com.dario.carrizo.gloaballogicchallenge.data.remote.ApiService
import com.dario.carrizo.gloaballogicchallenge.domain.repositories.ApiRepository
import javax.inject.Inject

/**
 * @author Dario Carrizo on 01/06/2022
 **/
class ApiRepositoryImplementation @Inject constructor(private val apiService: ApiService) : ApiRepository {

    override suspend fun getItems(): List<Products> {
        return apiService.getProducts()
    }
}