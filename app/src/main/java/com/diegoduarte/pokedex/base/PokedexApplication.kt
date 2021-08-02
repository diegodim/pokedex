package com.diegoduarte.pokedex.base

import com.diegoduarte.pokedex.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class PokedexApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}