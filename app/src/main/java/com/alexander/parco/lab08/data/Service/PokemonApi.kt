package com.alexander.parco.lab08.data.Service

import com.alexander.parco.lab08.data.models.payload.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("?limit=20")
    suspend fun getPokemons() : Response<PokemonListResponse>
}