package com.indodana.learnandroid.contract

interface MainContract {
    interface View {
        fun showResult(result: Int)
    }

    interface Presenter {
        fun sumNumber(firstNumber: Int, secondNumber: Int)
        fun onDestroy()
    }
}