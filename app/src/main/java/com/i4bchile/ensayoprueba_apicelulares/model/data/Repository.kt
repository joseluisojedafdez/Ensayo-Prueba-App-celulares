package com.i4bchile.ensayoprueba_apicelulares.model.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.i4bchile.ensayoprueba_apicelulares.model.ProductDetail

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

suspend fun getProductDetail(id: Int) {
        val response=RetrofitClient.retrofitInstance().getProductDetail(id)

        when(response.isSuccessful){

            true->{
                Log.d("Repository","Insertando producto detalle ${response.body()}")
                response.body()?.let{
                    database.productDao().loadProductDetail(it)
                }

            }
            false->{Log.d("Repository","error de conexión ${response.code()}")}
        }

    }

    fun getDetail(id: Int): LiveData<ProductDetail> {

        return database.productDao().getProductDetail(id)

    }


}