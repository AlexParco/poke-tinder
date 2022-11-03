package com.alexander.parco.lab08.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexander.parco.lab08.R
import com.alexander.parco.lab08.data.models.payload.PokemonResponse
import com.alexander.parco.lab08.databinding.ItemPokemonBinding
import com.bumptech.glide.Glide

class PokemonAdapter(
    var list: List<PokemonResponse>,
    val callback: CallBack,
): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_pokemon))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemPokemonBinding.bind(view)

        fun bind(pokemon: PokemonResponse){
            with(binding) {
                root.setOnClickListener{
                    callback.onClickPokemonInformation(pokemon)
                }
                tvName.text = pokemon.name
                Glide
                    .with(itemView)
                    .load(pokemon.getPokemonImage())
                    .into(binding.ivPokemon)
            }
        }
    }

    interface CallBack {
        fun onClickPokemonInformation(pokemon: PokemonResponse)
    }
}

fun ViewGroup.inflate(layoutRes: Int) : View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)
