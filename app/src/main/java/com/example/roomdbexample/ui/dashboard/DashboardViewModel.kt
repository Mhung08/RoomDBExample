package com.example.roomdbexample.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdbexample.ui.dashboard.view.ProductModel

class DashboardViewModel(name: String) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _listProduct = MutableLiveData<List<ProductModel>>().apply {
        value = listOf(
            ProductModel.Home(1,"test", 1),
            ProductModel.NewModel(2,1, "name2"),
            ProductModel.Fashion(3,"test3", "name3"),
            ProductModel.Home(4,"test", 1),
            ProductModel.NewModel(5,1, "name2"),
            ProductModel.Fashion(6,"test3", "name3"),
            ProductModel.Home(7,"test", 1),
            ProductModel.NewModel(8,1, "name2"),
            ProductModel.Fashion(9,"test3", "name3"),
            ProductModel.Home(10,"test", 1),
            ProductModel.NewModel(11,1, "name2"),
            ProductModel.Fashion(12,"test3", "name3"),
        )
    }
    val listProduct: LiveData<List<ProductModel>> = _listProduct
}