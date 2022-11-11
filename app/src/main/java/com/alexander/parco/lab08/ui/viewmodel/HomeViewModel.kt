package com.alexander.parco.lab08.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexander.parco.lab08.data.Service.PokemonApi
import com.alexander.parco.lab08.data.models.payload.PokemonResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel: ViewModel() {
    val pokemonList = MutableLiveData<List<PokemonResponse>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getAllPokemons()
    }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getAllPokemons() {
        isLoading.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            val call = buildRetrofit().create(PokemonApi::class.java).getPokemons()
            isLoading.postValue(false)
            if(call.isSuccessful){
                call.body()?.let {
                    pokemonList.postValue(it.results)
                }
            }
        }
    }

}