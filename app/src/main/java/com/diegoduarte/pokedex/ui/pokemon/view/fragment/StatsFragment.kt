package com.diegoduarte.pokedex.ui.pokemon.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegoduarte.pokedex.R
import com.diegoduarte.pokedex.base.BaseFragment
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.databinding.FragmentStatsBinding


class StatsFragment : BaseFragment<FragmentStatsBinding>() {

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStatsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        arguments?.takeIf { it.containsKey(ARG_POKEMON) }?.apply {
            val pokemon: Pokemon? = getParcelable(ARG_POKEMON)
            binding.stats = pokemon?.base
        }
        return binding.root
    }
}