package com.diegoduarte.pokedex.base

import androidx.fragment.app.Fragment

abstract class BaseFragment<T>: Fragment() {

    var _binding: T? = null

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}