package com.diegoduarte.pokedex.mvvm.pokedex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegoduarte.pokedex.R
import com.diegoduarte.pokedex.databinding.FragmentPokedexBinding
import com.diegoduarte.pokedex.mvvm.pokedex.PokedexViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class PokedexFragment : DaggerFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    internal val viewModel by viewModels<PokedexViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        // Inflate the layout for this fragment
        val binding = FragmentPokedexBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.pokedexList.setHasFixedSize(true)
        binding.pokedexList.setItemViewCacheSize(8)
        val manager = binding.pokedexList.layoutManager as GridLayoutManager
        val adapter = PokedexAdapter()
        binding.pokedexList.adapter = adapter

        viewModel.pokemonList.observe(viewLifecycleOwner, { list->
            list?.let {
                if(it.isNotEmpty()) {
                    adapter.submitList(it)
                    viewModel.statusDone()
                }
            }

        })


        binding.pokedexList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!viewModel.loading && manager.findLastVisibleItemPosition() >= manager.itemCount - 9) {
                    viewModel.nextPage()
                }
            }
        })
        return binding.root
    }


}