package com.i4bchile.ensayoprueba_apicelulares.model.data

import android.util.Log

class Repository {
    private val database=Database.ProductApplication.productDatabase!!
    val productList=database.productDao().getAllProducts()

suspend fun getProductList(){

    val response=RetrofitClient.retrofitInstance().getProducts()


    when (response.isSuccessful){

        true -> {
            Log.d("Repository", "getProductList con: ${response.body()?.size} elementos")
            response.body()?.let{
            database.productDao().loadAllProducts(it)}
        }

        false -> {
            Log.d("Repository", "error de conexión: ${response.code()} ")
        }
    }
}


}