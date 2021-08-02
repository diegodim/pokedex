package com.diegoduarte.pokedex.di.module

import androidx.lifecycle.ViewModel
import com.diegoduarte.pokedex.di.scope.ViewModelKey
import com.diegoduarte.pokedex.ui.pokemon.view.fragment.PokemonFragment
import com.diegoduarte.pokedex.ui.pokemon.PokemonViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class PokemonModule{


    @ContributesAndroidInjector(modules = [
        ViewModelModule::class
    ])
    internal abstract fun pokemonFragment(): PokemonFragment

    @Binds
    @IntoMap
    @ViewModelKey(PokemonViewModel::class)
    abstract fun bindViewModel(viewModel: PokemonViewModel): ViewModel
}