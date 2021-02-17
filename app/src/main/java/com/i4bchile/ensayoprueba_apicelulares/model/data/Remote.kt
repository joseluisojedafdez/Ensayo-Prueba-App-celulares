package com.i4bchile.ensayoprueba_apicelulares.model.data

interface PokeAPI {
    @GET("pokemon")
    suspend fun getPokemones(): Response<List<Pokemon>>

    @GET("pokemon/{pid}")
    suspend fun getPokemon(@Path("pid") id: Int): Response<PokeDetail>
}

class RetrofitClient {
    companion object {
        private const val BASE_URL =  "https://lapi-pokemon.herokuapp.com/"

        fun retrofitInstance(): PokeAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create())
                .build()

            return retrofit.create(PokeAPI::class.java)
        }
    }
}