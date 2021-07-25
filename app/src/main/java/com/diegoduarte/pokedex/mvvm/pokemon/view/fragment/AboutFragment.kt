package com.diegoduarte.pokedex.mvvm.pokemon.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {


    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(inflater)
        binding.lifecycleOwner = this
        arguments?.takeIf { it.containsKey(ARG_POKEMON) }?.apply {
            val pokemon: Pokemon? = getParcelable<Pokemon>(ARG_POKEMON)
            binding.pokemon = pokemon
        }
        return binding.root
    }


}