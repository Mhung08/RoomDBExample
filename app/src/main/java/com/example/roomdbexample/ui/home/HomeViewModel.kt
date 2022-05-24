package com.example.roomdbexample.ui.home

import android.app.backup.BackupAgentHelper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbexample.api.services.MainRepository
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val apiService : MainRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Get Token"
    }
    val text: LiveData<String> = _text

    fun getProductList() {
        viewModelScope.launch {
            val list = apiService.getProductList()
            Log.d("TAG","list: "+list.listProduct.size)
        }
    }
}