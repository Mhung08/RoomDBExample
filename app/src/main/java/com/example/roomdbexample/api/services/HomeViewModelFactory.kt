package com.example.roomdbexample.api.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbexample.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class HomeViewModelFactory constructor(private val mainRepository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                HomeViewModel(mainRepository) as T
        }else {
            throw IllegalArgumentException("Viewmodel not found")
        }
    }

}