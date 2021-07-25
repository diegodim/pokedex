package com.diegoduarte.pokedex.mvvm.pokemon.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.mvvm.pokemon.view.fragment.ARG_POKEMON

class PokemonInfoAdapter(fragment: Fragment, private val pokemon: Pokemon): FragmentStateAdapter(fragment) {

    private val fragmentList = ArrayList<Fragment>()
    fun addFragment(fragment: Fragment) {
        fragment.arguments = Bundle().apply {
            putParcelable(ARG_POKEMON, pokemon)
        }
        fragmentList.add(fragment)

    }

    override fun getItemCount(): Int  = fragmentList.size

    override fun createFragment(position: Int): Fragment {

        return fragmentList[position]
    }
}