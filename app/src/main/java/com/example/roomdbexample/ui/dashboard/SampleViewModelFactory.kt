package com.example.roomdbexample.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SampleViewModelFactory (val arg: String): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
           return DashboardViewModel(arg) as T
       }
       throw IllegalArgumentException(" Unknown ViewModel class ")
    }
}