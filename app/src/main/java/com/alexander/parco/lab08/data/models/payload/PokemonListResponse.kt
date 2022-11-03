package com.alexander.parco.lab08.data.models.payload

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<PokemonResponse>,
)
