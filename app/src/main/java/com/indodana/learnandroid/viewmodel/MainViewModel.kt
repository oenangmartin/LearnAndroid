package com.indodana.learnandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val result = MutableLiveData<Int>()

    fun sumNumber(firstNumber: Int, secondNumber: Int) {
        val total = firstNumber + secondNumber

        result.value = total
    }
}