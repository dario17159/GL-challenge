package com.dario.carrizo.gloaballogicchallenge.data.remote

import com.dario.carrizo.gloaballogicchallenge.data.model.ProductRepsonse
import com.dario.carrizo.gloaballogicchallenge.data.model.Products
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author Dario Carrizo on 01/06/2022
 **/
interface ApiClient {

    @GET("list")
    suspend fun getProducts(): Response<ProductRepsonse>
}