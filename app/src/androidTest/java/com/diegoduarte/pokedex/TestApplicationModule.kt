package com.diegoduarte.pokedex

import com.diegoduarte.pokedex.data.source.FakeTestAndroidRepository
import com.diegoduarte.pokedex.data.source.PokedexRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestApplicationModule {

    @Singleton
    @Provides
    fun provideRepository(): PokedexRepository = FakeTestAndroidRepository()
}