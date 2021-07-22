package com.diegoduarte.pokedex.di.module

import androidx.lifecycle.ViewModel
import com.diegoduarte.pokedex.mvvm.pokedex.view.PokedexFragment
import com.diegoduarte.pokedex.mvvm.pokedex.PokedexViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class PokedexModule {


    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun pokedexFragment(): PokedexFragment

    @Binds
    @IntoMap
    @ViewModelKey(PokedexViewModel::class)
    abstract fun bindViewModel(viewmodel: PokedexViewModel): ViewModel
}