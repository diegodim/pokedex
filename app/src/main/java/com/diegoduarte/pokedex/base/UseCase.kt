package com.diegoduarte.pokedex.base


import com.diegoduarte.pokedex.data.source.Result
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

abstract class UseCase<T, in Params>(private val scope: CoroutineScope) {

    abstract fun run(params: Params? = null): Flow<Result<T>>

    operator fun invoke(onSuccess: (T) -> Unit = {},
                        onError: ((Throwable) -> Unit) = {}){
        return invoke(null, onSuccess, onError)
    }
    operator fun invoke(params: Params?,
               onSuccess: (T) -> Unit = {},
               onError: ((Throwable) -> Unit) = {}){
        scope.launch(Dispatchers.IO) {

            run(params).collect {
                if (it is Result.Success) {
                    withContext(Dispatchers.Main) {
                        onSuccess(it.data)
                    }
                }
                else if (it is Result.Error) {
                    onError(it.exception)
                }
            }


        }

        fun cancel() = scope.coroutineContext.cancelChildren()
    }
}