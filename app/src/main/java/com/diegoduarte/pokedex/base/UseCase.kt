package com.diegoduarte.pokedex.base


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

abstract class UseCase<T, in Params>(private val scope: CoroutineScope) {

    abstract fun run(params: Params? = null): Flow<T>

    operator fun invoke(params: Params,
               onSuccess: (T) -> Unit = {},
               onError: ((Throwable) -> Unit) = {}
                ){
        scope.launch(Dispatchers.IO) {
            try {
                run(params).collect {
                    withContext(Dispatchers.Main) {
                        onSuccess(it)
                    }
                }
            }catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }

        }

        fun cancel() = scope.coroutineContext.cancelChildren()
    }
}