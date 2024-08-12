package com.example.myapplication.test

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SharedViewModel : ViewModel() {
    private val _singleEvent = MutableSharedFlow<Unit>(replay = 0) // replay = 0 确保不重播事件
    val singleEvent: SharedFlow<Unit> get() = _singleEvent
    private val _stateEvent = MutableStateFlow( 0) // replay = 0 确保不重播事件
    val stateEvent: MutableStateFlow<Int> get() = _stateEvent
    // 模拟异步任务
    fun performAsyncTask() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                delay(3000)
                _singleEvent.emit(Unit)
                Log.e("08080808", "performAsyncTask: ", )
            }


        }
    }

    fun performAsyncStateTask() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                delay(3000)
                _stateEvent.emit(1)
                Log.e("08080808", "performAsyncStateTask: ", )
            }


        }
    }
}