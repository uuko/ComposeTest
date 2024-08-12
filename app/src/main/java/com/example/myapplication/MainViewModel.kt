package com.example.myapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var type by mutableStateOf(Type.MIDDLE)
        private set

    fun changeType(type: Type) {
        this.type = type
    }
}