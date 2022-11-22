package com.alexander.parco.lab08.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.alexander.parco.lab08.data.database.entities.MyPokemonEntity
import com.alexander.parco.lab08.databinding.FragmentFavoriteBinding
import com.alexander.parco.lab08.ui.adapter.MyPokemonsAdapter
import com.alexander.parco.lab08.ui.viewmodel.FavoriteViewModel

class FavoriteFragment: BaseFragment<FragmentFavoriteBinding> (FragmentFavoriteBinding::inflate) {
    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private val listMyPokemon = mutableListOf<MyPokemonEntity>()
    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteViewModel.getMyPokemons(requireContext())

        binding.rvPokemons.adapter = adapter

        favoriteViewModel.myPokemonList.observe(this) {
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }

        binding.floatingActionDelete.setOnClickListener{
            favoriteViewModel.deleteAllPokemon(requireContext())
        }
        //favoriteViewModel.deleteAllPokemon(requireContext())
    }
}