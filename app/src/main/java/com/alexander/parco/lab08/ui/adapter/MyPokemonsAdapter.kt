package com.alexander.parco.lab08.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexander.parco.lab08.R
import com.alexander.parco.lab08.data.database.entities.MyPokemonEntity
import com.alexander.parco.lab08.ui.holder.MyPokemonHolder

class MyPokemonsAdapter(val list: List<MyPokemonEntity>): RecyclerView.Adapter<MyPokemonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonHolder {
        val view = parent.inflate(R.layout.item_pokemon_saved)
        return MyPokemonHolder(view)
    }

    override fun onBindViewHolder(holder: MyPokemonHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size
}