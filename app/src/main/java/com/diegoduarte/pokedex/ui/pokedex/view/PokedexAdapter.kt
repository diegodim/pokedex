package com.diegoduarte.pokedex.ui.pokedex.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.databinding.ItemPokemonBinding

class PokedexAdapter(private val onClickListener: OnClickListener ):
    ListAdapter<Pokemon, PokedexAdapter.PokemonViewHolder>(PokemonDiffCallback)  {


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(pokemon)
        }
        holder.bind(pokemon)
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

    class OnClickListener(val clickListener: (marsProperty:Pokemon) -> Unit) {
        fun onClick(marsProperty:Pokemon) = clickListener(marsProperty)
    }
}

