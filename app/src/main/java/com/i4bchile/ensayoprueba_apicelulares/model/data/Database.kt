package com.i4bchile.ensayoprueba_apicelulares.model.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Database
import com.i4bchile.ensayoprueba_apicelulares.model.Product
import com.i4bchile.ensayoprueba_apicelulares.model.ProductDetail

class Database {

    @Dao
    interface ProductDao{

        @Insert(onConflict= OnConflictStrategy.REPLACE)
        suspend fun loadAllProducts(productList:List<Product>)

        @Query("SELECT * FROM product")
        fun getAllProducts(): LiveData<List<Product>>

        @Insert(onConflict=OnConflictStrategy.REPLACE)
        suspend fun loadProductDetail(productDetail:ProductDetail)

        @Query("SELECT *FROM productdetail WHERE id=:pId")
        fun getProductDetail(pId:Int):LiveData<ProductDetail>

    }

    @Database(entities=[Product::class,ProductDetail::class],version=1)
     abstract class ProductDatabase: RoomDatabase() {
        abstract fun productDao():ProductDao
    }

    class ProductApplication: Application(){
        companion object{
            var productDatabase:ProductDatabase?=null

        }

        override fun onCreate(){
            super.onCreate()

            productDatabase=Room.databaseBuilder(this,ProductDatabase::class.java,"poke_db").build()
        }
    }

}