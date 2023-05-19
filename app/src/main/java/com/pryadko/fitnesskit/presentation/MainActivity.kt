package com.pryadko.fitnesskit.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pryadko.fitnesskit.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = getColor(com.pryadko.fintesskit.core.theme.R.color.black)
    }
}