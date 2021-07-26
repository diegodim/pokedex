package com.diegoduarte.pokedex.mvvm.pokedex.view

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegoduarte.pokedex.R
import com.diegoduarte.pokedex.databinding.FragmentPokedexBinding
import com.diegoduarte.pokedex.mvvm.pokedex.PokedexViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class PokedexFragment : DaggerFragment() {

    private var _binding: FragmentPokedexBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    internal val viewModel by viewModels<PokedexViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        _binding = FragmentPokedexBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        (activity as AppCompatActivity?)!!.window.statusBarColor = context?.getColor(R.color.black_40)!!

        binding.pokedexList.setHasFixedSize(true)
        binding.pokedexList.setItemViewCacheSize(8)
        val adapter = PokedexAdapter( PokedexAdapter.OnClickListener{
            viewModel.displayPokemon(it)
        })
        binding.pokedexList.adapter = adapter

        viewModel.pokemonList.observe(viewLifecycleOwner, { list->
            list?.let {
                if(it.isNotEmpty()) {
                    adapter.submitList(it)
                    viewModel.statusDone()
                }
            }
        })

        viewModel.navigateToSelectedPokemon.observe(viewLifecycleOwner,  {
            if ( null != it ) {
                // Must find the NavController from the Fragment
                this.findNavController().navigate(PokedexFragmentDirections.actionPokedexFragmentToPokemonFragment(it))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                viewModel.displayPokemonComplete()
            }
        })
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding.pokedexList.adapter = null
        _binding?.unbind()
        _binding = null


    }

}