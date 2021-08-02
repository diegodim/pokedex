package com.diegoduarte.pokedex

import android.content.Context
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.di.module.DataModule
import com.diegoduarte.pokedex.di.module.PokedexModule
import com.diegoduarte.pokedex.di.module.PokemonModule
import com.diegoduarte.pokedex.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import org.junit.runner.manipulation.Ordering
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataModule::class,
    TestApplicationModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    PokedexModule::class,
    PokemonModule::class])
interface TestApplicationComponent : AndroidInjector<TestPokedexApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): TestApplicationComponent
    }


    val pokedexRepository: PokedexRepository
}