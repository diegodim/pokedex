package com.diegoduarte.pokedex.ui.pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.ui.pokedex.domain.GetPokemonList
import com.diegoduarte.pokedex.ui.pokedex.domain.RefreshPokemonList
import com.diegoduarte.pokedex.utils.ApiStatus
import com.diegoduarte.pokedex.utils.Event
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

    private val _openPokemonEvent = MutableLiveData<Event<Pokemon?>>()

    // The external immutable LiveData for the navigation property
    val openPokemonEvent: LiveData<Event<Pokemon?>>
        get() = _openPokemonEvent

    init {
        _status.value = ApiStatus.LOADING
        refreshPokemon()
        getPokemonList(
            params = null,
            onSuccess = {
                _pokemonList.value = it
                _status.value = ApiStatus.DONE },
            onError = { })
    }

    private fun refreshPokemon(){
        refreshData(onError = { })
    }


    fun openPokemon(pokemon: Pokemon){
        _openPokemonEvent.value = Event(pokemon)
    }


}