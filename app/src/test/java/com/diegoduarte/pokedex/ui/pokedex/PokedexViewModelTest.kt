package com.diegoduarte.pokedex.ui.pokedex

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.diegoduarte.pokedex.TestCoroutineRule
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.data.source.Result
import com.diegoduarte.pokedex.utils.ApiStatus
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokedexViewModelTest {

    @Mock
    private lateinit var repository: PokedexRepository

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: PokedexViewModel

    @Test
    fun loadAllPokemonFromRepository_loadingTogglesAndDataLoaded() = testCoroutineRule.runBlockingTest {
        // Given
        val pokemons = listOf(
            Pokemon(),
            Pokemon(),
            Pokemon()
        )
        given(repository.refreshPokemonList())
            .willReturn(flow { emit(Result.Loading) })
        given(repository.listPokemon)
            .willReturn(flow { emit(Result.Success(pokemons)) })


        // When
        viewModel = PokedexViewModel(repository)


        //Then
        val value = viewModel.pokemonList.getOrAwaitValue()
        //val status = viewModel.status.getOrAwaitValue()

        assertNotNull(value)
        //assertEquals(ApiStatus.DONE, status)
        assertEquals(pokemons, value)

    }
}