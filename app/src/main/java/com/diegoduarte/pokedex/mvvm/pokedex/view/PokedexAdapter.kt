package com.diegoduarte.pokedex.mvvm.pokedex.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.databinding.ItemPokemonBinding

class PokedexAdapter:
    ListAdapter<Pokemon, PokedexAdapter.PokemonViewHolder>(PokemonDiffCallback)  {


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder.from(parent)
    }

    class PokemonViewHolder private constructor(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: Pokemon) {

            binding.pokemon = pokemon
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): PokemonViewHolder {
                val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return PokemonViewHolder(binding)
            }
        }
    }

    companion object PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

