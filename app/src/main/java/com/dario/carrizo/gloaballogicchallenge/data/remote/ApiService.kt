package com.dario.carrizo.gloaballogicchallenge.data.remote

import com.dario.carrizo.gloaballogicchallenge.data.model.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Dario Carrizo on 01/06/2022
 **/
class ApiService @Inject constructor(private val apiClient: ApiClient) {
    suspend fun getProducts(): List<Products>{
        return withContext(Dispatchers.IO){
            val response = apiClient.getProducts()
            response.body() ?: emptyList()
        }
    }
}