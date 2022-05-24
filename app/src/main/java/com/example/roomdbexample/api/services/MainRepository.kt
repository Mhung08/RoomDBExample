package com.example.roomdbexample.api.services

import com.example.roomdbexample.room.DB.AppDatabase

class MainRepository constructor(
    private val apiRetrofit : RetrofitService,
    private val appDatabase: AppDatabase
) {
    suspend fun getProductList() = apiRetrofit.getListProduct()

}