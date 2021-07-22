package com.diegoduarte.pokedex.mvvm.pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.mvvm.pokedex.domain.RefreshData
import com.diegoduarte.pokedex.utils.ApiStatus
import javax.inject.Inject

class PokedexViewModel @Inject constructor(repository: PokedexRepository):
    ViewModel() {


    private val refreshData = RefreshData(repository, viewModelScope)
    private var _offset: Int
    private var _limit: Int

    var loading: Boolean

    val pokemonList = repository.listPokemon

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<ApiStatus>()
    // The external immutable LiveData for the request status
    val status: LiveData<ApiStatus>
        get() = _status

    init {
        _offset = 0
        _limit = 20
        _status.value = ApiStatus.LOADING
        loading = true
        refreshPokemon(_offset, _limit)
    }

    private fun refreshPokemon(offset: Int, limit: Int){
        refreshData(
            RefreshData.Params(offset, limit),
            onSuccess = { _status.value = ApiStatus.DONE },
            onError = { loading = false }
        )
    }



    fun nextPage(){
        loading = true
        _offset = pokemonList.value!!.size
        refreshPokemon(_offset, _limit)
    }

    fun statusDone(){
        loading = false
        _status.value = ApiStatus.DONE
    }

}