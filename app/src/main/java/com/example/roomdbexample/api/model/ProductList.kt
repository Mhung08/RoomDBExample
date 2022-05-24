package com.example.roomdbexample.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class ProductList (
    @SerializedName("products")
    var listProduct : List<ProductAPI>
) : Parcelable