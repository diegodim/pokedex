package com.diegoduarte.pokedex.ui.pokedex.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.diegoduarte.pokedex.R
import com.diegoduarte.pokedex.data.model.Name
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.data.source.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.MockitoAnnotations


@MediumTest
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class PokedexFragmentTest {

//    @Mock
//    private lateinit var repository: PokedexRepository

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()


    @Test
    fun activePokedex_DisplayedInUi() = runBlockingTest {
        val pokemon = Pokemon(
            id = 1,
            name = Name("Test"),

        )
        val pokemons = listOf(
            pokemon
        )

//        BDDMockito.given(repository.refreshPokemonList())
//            .willReturn(flow { emit(Result.Loading) })
//        BDDMockito.given(repository.listPokemon)
//            .willReturn(flow { emit(Result.Success(pokemons)) })


        launchFragmentInContainer<PokedexFragment>(null, R.style.Theme_PokeDex_NoActionBar)
        Thread.sleep(5000)
    }

}