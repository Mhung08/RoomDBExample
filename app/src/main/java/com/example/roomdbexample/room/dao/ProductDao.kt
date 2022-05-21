package com.example.roomdbexample.room.dao

import androidx.room.*
import com.example.roomdbexample.room.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: Product)

    @Delete
    suspend fun removeProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)


}