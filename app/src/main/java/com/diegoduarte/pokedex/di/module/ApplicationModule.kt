package com.diegoduarte.pokedex.di.module


import android.app.Application
import android.content.Context
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.data.source.PokedexRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ApplicationModule{

    @Singleton
    @Binds
    abstract fun bindRepository(repo: PokedexRepositoryImpl): PokedexRepository


}