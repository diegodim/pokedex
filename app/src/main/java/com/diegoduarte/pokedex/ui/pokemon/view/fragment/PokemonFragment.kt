package com.diegoduarte.pokedex.ui.pokemon.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.diegoduarte.pokedex.R
import com.diegoduarte.pokedex.databinding.FragmentPokemonBinding
import com.diegoduarte.pokedex.ui.pokemon.PokemonViewModel
import com.diegoduarte.pokedex.ui.pokemon.view.adapter.PokemonInfoAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_pokemon.*
import javax.inject.Inject

const val ARG_POKEMON = "pokemon"

class PokemonFragment : Fragment() {


    private val args: PokemonFragmentArgs by navArgs()
    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!
    private var tabLayoutMediator: TabLayoutMediator? = null
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    internal val viewModel by viewModels<PokemonViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        _binding = FragmentPokemonBinding.inflate(inflater)

        binding.lifecycleOwner = this

        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.pokemonToolbar)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity?)!!.window.statusBarColor = context?.getColor(args.pokemon.color)!!
        binding.pokemon = args.pokemon


        val rotate: Animation = AnimationUtils.loadAnimation(this.context, R.anim.rotate)
        binding.pokeballImage.startAnimation(rotate)
        val pageAdapter = PokemonInfoAdapter(this, args.pokemon)
        binding.pokemonPager.adapter = pageAdapter

        pageAdapter.addFragment(AboutFragment())
        pageAdapter.addFragment(Fragment())
        pageAdapter.addFragment(Fragment())
        pageAdapter.addFragment(Fragment())

        tabLayoutMediator = TabLayoutMediator(binding.pokemonTab, binding.pokemonPager){ tab, position ->
            tab.id = position
            when(position){
                0 -> tab.text ="Sobre"
                1 -> tab.text ="Status Base"
                2 -> tab.text ="Evoluções"
                3 -> tab.text ="Golpes"
            }
        }
        tabLayoutMediator?.attach()


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as AppCompatActivity?)!!.setSupportActionBar(null)
        tabLayoutMediator?.detach()
        tabLayoutMediator = null
        binding.pokemonPager.adapter = null
        _binding?.unbind()
        _binding = null

    }

}