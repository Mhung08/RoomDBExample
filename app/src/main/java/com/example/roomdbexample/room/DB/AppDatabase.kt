package com.example.roomdbexample.room.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbexample.room.dao.ProductDao
import com.example.roomdbexample.room.entity.Product

@Database(
    entities = [Product::class],
//    autoMigrations = [
//        AutoMigration (from = 1, to = 2)
//    ],
    version = 1,
    exportSchema = true
)
//@TypeConverters(NoteConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

//        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                // The following query will add a new column called lastUpdate to the notes database
//                database.execSQL("ALTER TABLE products ADD COLUMN lastUpdate INTEGER NOT NULL DEFAULT 0")
//            }
//        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "cart_database"
            )
                //.addMigrations(MIGRATION_1_2)
                .build()
        }
    }
}
