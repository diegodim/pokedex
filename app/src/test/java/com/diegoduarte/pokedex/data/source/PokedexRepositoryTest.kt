package com.diegoduarte.pokedex.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import com.diegoduarte.pokedex.TestCoroutineRule
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.LocalDataSource
import com.diegoduarte.pokedex.data.source.local.entities.PokemonEntity
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper
import com.diegoduarte.pokedex.data.source.remote.RemoteDataSource
import com.diegoduarte.pokedex.data.source.remote.mapper.PokemonResponseMapper
import com.diegoduarte.pokedex.data.source.remote.model.*
import com.diegoduarte.pokedex.ui.pokedex.PokedexViewModel
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import junit.framework.Assert
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.hamcrest.core.Is
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.BDDMockito.`when` as whenever
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner
import kotlin.text.Typography.times

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokedexRepositoryTest{

    @Mock
    private lateinit var localDataSource: LocalDataSource

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var repository: PokedexRepository

    @Before
    fun createRepository() {

        repository = PokedexRepositoryImpl(localDataSource, remoteDataSource)
    }

    @Test
    fun  refreshPokemon_requestAllPokemonFromRemoteDataSource() = testCoroutineRule.runBlockingTest{
        // Given
        val pokemon = PokemonResponse(
            id = 1,
            name = NameResponse(""),
            type = listOf(""),
            base = StatsResponse(1,1,1,1,1,1),
            evolution = EvolutionResponse(listOf(""), listOf(listOf(""))),
            profile = ProfileResponse("","", listOf(""), listOf(listOf("")),"")
        )
        val pokemons = listOf(
            pokemon,
            pokemon,
            pokemon)
        val local = PokemonEntityMapper().toLocal(PokemonResponseMapper().toDomain(pokemon))
        given(remoteDataSource.refreshPokemonList()).willReturn(Result.Success(pokemons))


        // When
        val value = repository.refreshPokemonList().asLiveData().getOrAwaitValue()


        // Then
        assertNotNull(value)
        assertEquals(value, Result.Loading)
        then(localDataSource).should(times(3)).insertPokemon(local)

    }

}