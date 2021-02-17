package com.i4bchile.ensayoprueba_apicelulares.model.data

import android.util.Log

class Repository {

suspend fun getProductList(){

    val response=RetrofitClient.retrofitInstance().getProducts()

    when (response.isSuccessful){

        true -> {
            Log.d("Repository", "getProductList con: ${response.body()?.size} elementos")
        }

        false -> {
            Log.d("Repository", "error de conexión: ${response.code()} ")
        }
    }
}


}