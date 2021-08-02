package com.diegoduarte.pokedex.di.component

import android.content.Context
import com.diegoduarte.pokedex.base.PokedexApplication
import com.diegoduarte.pokedex.di.module.ApplicationModule
import com.diegoduarte.pokedex.di.module.DataModule
import com.diegoduarte.pokedex.di.module.PokedexModule
import com.diegoduarte.pokedex.di.module.PokemonModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        PokedexModule::class,
        PokemonModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<PokedexApplication> {


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}