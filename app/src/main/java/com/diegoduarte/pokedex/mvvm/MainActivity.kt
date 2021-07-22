package com.diegoduarte.pokedex.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diegoduarte.pokedex.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}