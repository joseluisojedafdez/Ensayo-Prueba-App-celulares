package com.i4bchile.ensayoprueba_apicelulares.model.data

import com.i4bchile.ensayoprueba_apicelulares.model.Product
import com.i4bchile.ensayoprueba_apicelulares.model.ProductDetail
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {
    @GET("products/")
    suspend fun getProducts(): Response<List<Product>>

    @GET("details/{pid}")
    suspend fun getProductDetail(@Path("pid") id: Int): Response<ProductDetail>
}

class RetrofitClient {
    companion object {
        private const val BASE_URL =  "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"

        fun retrofitInstance(): PokeAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create())
                .build()

            return retrofit.create(PokeAPI::class.java)
        }
    }
}