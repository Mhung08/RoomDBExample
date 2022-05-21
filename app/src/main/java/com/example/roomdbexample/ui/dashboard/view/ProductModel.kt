package com.example.roomdbexample.ui.dashboard.view

sealed class ProductModel(val key: Int) {
    data class Fashion(
        val keyFa: Int,
        val name: String,
        val title: String
    ) : ProductModel(keyFa)

    data class NewModel(
        val keyNew: Int,
        val id: Int,
        val name: String
    ) : ProductModel(keyNew)

    data class Home(
        val keyHome: Int,
        val name: String,
        val amount: Int
    ) : ProductModel(keyHome)
}
