package com.dario.carrizo.gloaballogicchallenge.domain.repositories

import androidx.lifecycle.MutableLiveData
import com.dario.carrizo.gloaballogicchallenge.data.model.Products

/**
 * @author Dario Carrizo on 01/06/2022
 **/
interface ApiRepository {
    suspend fun getItems(): List<Products>
}