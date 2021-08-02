package com.diegoduarte.pokedex.ui.pokemon.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegoduarte.pokedex.base.BaseFragment
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.databinding.FragmentAboutBinding


class AboutFragment : BaseFragment<FragmentAboutBinding>() {

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAboutBinding.inflate(inflater)
        binding.lifecycleOwner = this
        arguments?.takeIf { it.containsKey(ARG_POKEMON) }?.apply {
            val pokemon: Pokemon? = getParcelable(ARG_POKEMON)
            binding.profile = pokemon?.profile
        }
        return binding.root
    }

}