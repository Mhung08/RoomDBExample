package com.example.roomdbexample.api.services

import com.example.roomdbexample.api.model.ProductList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("5def7b172f000063008e0aa2")
    suspend fun getListProduct() : ProductList

    companion object {
        private var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
               val retrofit = Retrofit.Builder()
                   .baseUrl("https://www.mocky.io/v2/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}