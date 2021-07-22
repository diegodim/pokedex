package com.diegoduarte.pokedex.di.component

import android.content.Context
import com.diegoduarte.pokedex.base.BaseApplication
import com.diegoduarte.pokedex.di.module.ApplicationModule
import com.diegoduarte.pokedex.di.module.PokedexModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        PokedexModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}