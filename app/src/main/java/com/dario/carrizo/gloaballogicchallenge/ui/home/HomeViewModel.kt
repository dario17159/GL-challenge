package com.dario.carrizo.gloaballogicchallenge.ui.home

import android.os.ProxyFileDescriptorCallback
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dario.carrizo.gloaballogicchallenge.data.model.Products
import com.dario.carrizo.gloaballogicchallenge.data.remote.ApiService
import com.dario.carrizo.gloaballogicchallenge.domain.repositories.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Dario Carrizo on 01/06/2022
 **/
@HiltViewModel
class HomeViewModel @Inject constructor(private val apiRepository: ApiRepository): ViewModel() {

    val products = MutableLiveData<List<Products>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getProducts(){
        viewModelScope.launch {
            isLoading.value = true
            val result = apiRepository.getItems()
            products.value = result
            isLoading.value = false
        }
    }
}