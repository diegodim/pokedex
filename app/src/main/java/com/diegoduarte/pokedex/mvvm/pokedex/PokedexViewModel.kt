package com.diegoduarte.pokedex.mvvm.pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.mvvm.pokedex.domain.GetPokemonList
import com.diegoduarte.pokedex.mvvm.pokedex.domain.RefreshPokemonList
import com.diegoduarte.pokedex.utils.ApiStatus
import javax.inject.Inject

class PokedexViewModel @Inject constructor(repository: PokedexRepository):
    ViewModel() {



    private val refreshData = RefreshPokemonList(repository, viewModelScope)
    private val getPokemonList = GetPokemonList(repository, viewModelScope)

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>>
        get() = _pokemonList
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<ApiStatus>()
    // The external immutable LiveData for the request status
    val status: LiveData<ApiStatus>
        get() = _status

    private val _navigateToSelectedPokemon = MutableLiveData<Pokemon?>()

    // The external immutable LiveData for the navigation property
    val navigateToSelectedPokemon: LiveData<Pokemon?>
        get() = _navigateToSelectedPokemon

    init {
        _status.value = ApiStatus.LOADING
        refreshPokemon()
        getPokemonList(
            params = null,
            onSuccess = { _pokemonList.value = it },
            onError = { })
    }

    private fun refreshPokemon(){

        refreshData(
            params = null,
            onSuccess = {  },
            onError = {  }
        )
    }



    fun statusDone(){
        _status.value = ApiStatus.DONE
    }

    fun displayPokemon(pokemon: Pokemon){
        _navigateToSelectedPokemon.value = pokemon
    }

    fun displayPokemonComplete(){
        _navigateToSelectedPokemon.value = null
    }

}