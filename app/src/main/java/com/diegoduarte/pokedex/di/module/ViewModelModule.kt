package com.diegoduarte.pokedex.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diegoduarte.pokedex.base.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}

